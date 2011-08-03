drop database IF EXISTS Proca;
create database Proca;
use Proca;
--  domain - таблица, в которой хранятся домены (используются в таблице subscribers)
--  status может принимать значения:
--    0 -  домен временно приостановлен (временно не доставляем почту)
--    1 -  активный домен
--    9 -  домен, всем сабскрайберам с которого запрещено посылать почту

create table domain (
    id                                  int auto_increment primary key,
    status                              tinyint default 1,
    domain                              varchar( 64 ) not null unique,
    comment                             varchar( 128 ) default ''
);                                     
           


--  country - страны
--  status может принимать значения:
--    0 -  disabled
--    1 -  active
--  code - двухбуквенный код страны
                            
CREATE TABLE country (                 
    id                                  smallint auto_increment primary key,
    status                              tinyint default 1,
    code                                CHAR( 2 ) NOT NULL,
    name                                VARCHAR( 64 ) NOT NULL,
    index (code)
);                                     
                                       

--  state - штаты
--  status может принимать значения:
--    0 -  штат "disabled"
--    1 -  active
--  code - двухбуквенный код штата
--  country_id - код страны, которой принадлежит штат
                                       
CREATE TABLE state (                   
    id                                  smallint auto_increment primary key,
    status                              tinyint default 1,
    code                                CHAR( 2 ) NOT NULL,
    name                                VARCHAR( 64 ) NOT NULL,
    country_id                          smallINT NOT NULL,
    index (code)
);                                     



--  template - таблица шаблонов 
--             используются для отображения различных страниц подписчикам, 
--             нотификационных писем и т.д.
--  type_id - тип шаблона, принимает следующие значения:
--            SUBS_CONFIRM_EMAIL     2 шаблон письма подтверждения подписки
--            UNSUBS_CONFIRM_EMAIL   3 письмо подтверждение отписки
--            SUBS_EMAIL             4 письмо подписчик подписан
--            UNSUBS_EMAIL           5 письмо подписчик отписан
--            SUBS_PAGE              6 шаблон подписной страницы 
--            UNSUBS_PAGE            7 отписной страницы
--            SUBS_CONFIRM_PAGE      8 страница подтверждения подписки
--            UNSUBS_CONFIRM_PAGE    9 подтверждения отписки
--            CONVERSION_EMAIL      10 нотификационное письмо посылаемое паблишеру 
--            HTML_PAGE             11 html страница 
--
--   html / text - текстовая и html части письма ( в случае web - text пустой )
--   from_name - от чьего имени посылать письмо ( вслучае шаблона письма )
--   subject - поле темы письма

CREATE TABLE template (
    id                                  smallint auto_increment primary key ,
    type_id                             tinyint DEFAULT 1 NOT NULL,
    name                                varchar(32),
    description                         varchar(256),
    from_name                           varchar(256),
    subject                             text,
    text                                text,
    html                                text
);


--  srcdomain таблица "доменов отсылки" - тех доменов, от имени 
--            которых система может посылать письма подписчикам 
--            (в поле return_to, отписные линки и пр.) 
--  status может принимать значения:
--    0 -  disabled
--    1 -  active
--
--  name - доменное имя
--  smtp - адрес мэйл сервера, через который отсылаются нотификационные письма
--  path - путь, по которому установолена(смапирована) приложение для этого домена
--  default_conversion_code_id - умолчательный код подписки, используется при получении 
--         подписки по почте
--  unsubs_****** - настройки какие шаблоны и как именно обрабатывается отписка 
--                  по умолчанию для этого домена отсылки

CREATE TABLE srcdomain (
    id                                  smallint auto_increment PRIMARY KEY,
    status                              tinyint default 1,
    name                                varchar(128) unique,
    smtp                                varchar(128) NOT NULL,
    path                                varchar(128) NOT NULL,

    default_conversion_code_id          smallint default NULL,

    unsubs_confirm                      bool NOT NULL DEFAULT true,
    unsubs_confirm_e_id                 smallint, -- references template ("id") on delete set NULL
    unsubs_confirm_h_id                 smallint, -- references template ("id") on delete set NULL
    unsubs_confirm_url                  character varying(256),
    unsubs_confirm_rwt                  BOOL default false,
    unsubs_choice                       bool NOT NULL DEFAULT true,
    unsubs_choice_h_id                  smallint, -- references template ("id") on delete set NULL
    unsubs_goodbye_h_id                 smallint, -- references template ("id") on delete set NULL
    unsubs_goodbye_e_id                 smallint, -- references template ("id") on delete set NULL
    unsubs_goodbye_url                  character varying(256),
    unsubs_goodbye_rwt                  bool default false
);


-- conversion_code. 
--  само по себе понятие конверсия подразумевает действие типа совершение покупки
--  покупателем в электронном магазине, или заполнение пользователем какой то формы.
--  конверсия есть желаемый результат рекламной деятельности в цепочке событий:
--     показываются баннера, рассылается реклама по почте, крутят рекламу паблишеры;
--     часть увидевших рекламу кликают на баннер / ссылку;
--     в свою очередь часть из кликнувших, делают покупку в магазине (т.е. совершают конверсию)
--  соответственно обычно есть несколько основных типов конверсий:
--  sale - продажа чего то ( type_id = 1 )
--  lead - "привод" - факт заполнения пользователем какой то формы, подписки ( type_id = 2 )
--  rebill - похоже на sale, только обозначает повторяющее действие, к примеру 
--           была компания по продвижению услуг сотовой связи. когда покупатель 
--           приходит первый раз и совершает покупку сервиса, система протоколирует это с типом 
--           sale. дальше, каджый месяц будут приходить платежи абонетской платы, и такие платежи 
--           сохраняются с типом rebill ( type_id = 3 )
--
-- для удобства сохранения / трассировки конверсий в системе есть понятие
-- конверсионный код. немного о ео назначениии:
-- в мире есть тысячи разных програм - онлайн магазинов, сервисов и приложений по обработке форм. 
-- каждая из таких форм имет свои параметры, свой стиль работы.
-- для того чтобы можно было "настроить" приложение под каждый такой магазин / форму индивидуально,
-- в системе есть понятие конверсионный код. в нем настраиваются имена параметров в которых приходит
-- поля типа суммы заказа, номера заказа, имэйл адреса и пр. детали.
--
-- так же конверсионный коды используется для добавление (подписки) подписчиков в систему
-- в конверсионном коде настраивается допольнительные действия, которые должна предпринять
-- система при протоколировании конверсии - послать нотификационное письмо, отобразить страницу,
-- отредиректить на какой то УРЛ и т.д.
--
-- каждый конверсионный код имеет свой уникальный URL, который вызывается магазином/формой
-- для передачи заданий параметров через GET / POST / ... запрос
-- 

CREATE TABLE conversion_code (
    id                                  smallint auto_increment primary key,
    name                                VARCHAR( 64 ) NOT NULL,
    type_id                             tinyint NOT NULL DEFAULT 1,
    type_id_pname                       VARCHAR( 32 ) default 'type_id',
    campaign_id_pname                   VARCHAR( 32 ) default 'campaign_id',
    publisher_id_pname                  VARCHAR( 32 ) default 'publisher_id',
    custom_id_pname                     VARCHAR( 32 ) DEFAULT 'id',
    status_pname                        VARCHAR( 32 ) DEFAULT 'status',
    default_status                      tinyint default 1,
                                       
    redirect_url                        varchar( 255 ) default '',
    redirect_rewrite                    BOOL default false,
    log_unreferred                      bool default true,
    log_diplicate_id                    bool default true,
    log_diplicate_cookie                bool default true,
                                       
    default_amount                      DOUBLE default 0.00,
    amount_param                        varchar( 32 )  default 'amount',
                                       
    subscribe                           bool default true,
    confirm_on_subscribe                bool default true,
                                       
    email_pname                         VARCHAR( 32 ) DEFAULT 'email',
                                       
    accept_id                           bool,
    id_pname                            VARCHAR( 32 ) DEFAULT 'sid',
                                       
    accept_md5_code                     bool,
    md5_code_pname                      VARCHAR( 32 ) DEFAULT 'c',
                                       
    accept_newslist                     bool,
    newslist_pname                      VARCHAR( 32 ) DEFAULT 'newslist',
                                      
    accept_password                     bool,
    password_pname                      VARCHAR( 32 ) DEFAULT 'password',

    accept_fname                        bool,
    fname_pname                         VARCHAR( 32 ) DEFAULT 'fname',

    accept_lname                        bool,
    lname_pname                         VARCHAR( 32 ) DEFAULT 'lname',
                                       
    accept_sex                          bool,
    sex_pname                           VARCHAR( 32 ) DEFAULT 'sex',
                                       
    accept_address1                     bool,
    address1_pname                      VARCHAR( 32 ) DEFAULT 'address1',
                                       
    accept_address2                     bool,
    address2_pname                      VARCHAR( 32 ) DEFAULT 'address2',
                                       
    accept_city                         bool,
    city_pname                          VARCHAR( 32 ) DEFAULT 'city',
                                       
    accept_state                        bool,
    state_pname                         VARCHAR( 32 ) DEFAULT 'state',
                                       
    accept_zip                          bool,
    zip_pname                           VARCHAR( 32 ) DEFAULT 'zip',
                                       
    accept_country                      bool,
    country_pname                       VARCHAR( 32 ) DEFAULT 'country',
                                       
    accept_phone1                       bool,
    phone1_pname                        VARCHAR( 32 ) DEFAULT 'phone1',
                                       
    accept_phone2                       bool,
    phone2_pname                        VARCHAR( 32 ) DEFAULT 'phone2',
                                       
    accept_custom1                      bool,
    custom1_pname                       VARCHAR( 32 ) DEFAULT 'custom1',
                                       
    accept_custom2                      bool,
    custom2_pname                       VARCHAR( 32 ) DEFAULT 'custom2',
                                       
    accept_custom3                      bool,
    custom3_pname                       VARCHAR( 32 ) DEFAULT 'custom3',
                                       
    accept_custom4                      bool,
    custom4_pname                       VARCHAR( 32 ) DEFAULT 'custom3',
                                       
    accept_custom5                      bool,
    custom5_pname                       VARCHAR( 32 ) DEFAULT 'custom3',
                                       
    accept_custom6                      bool,
    custom6_pname                       VARCHAR( 32 ) DEFAULT 'custom3',
                                       
    accept_custom7                      bool,
    custom7_pname                       VARCHAR( 32 ) DEFAULT 'custom3',
                                       
    accept_custom8                      bool,
    custom8_pname                       VARCHAR( 32 ) DEFAULT 'custom3',
                                       
    accept_custom9                      bool,
    custom9_pname                       VARCHAR( 32 ) DEFAULT 'custom3',
                                       
    homepage_template_id                smallint, -- REFERENCES "template" ON DELETE SET NULL
                                       
    subs_confirm                        BOOL NOT NULL DEFAULT true,
    subs_confirm_e_id                   smallint, -- REFERENCES "template" ON DELETE SET NULL
    subs_confirm_e2_id                  smallint, -- REFERENCES "template" ON DELETE SET NULL
    subs_confirm_h_id                   smallint, -- REFERENCES "template" ON DELETE SET NULL
    subs_confirm_url                    VARCHAR( 255 ),
    subs_confirm_rwt                    bool,
    subs_welcome                        bool DEFAULT true,
    subs_welcome_h_id                   smallint, -- REFERENCES "template" ON DELETE SET NULL
    subs_welcome_e_id                   smallint, -- REFERENCES "template" ON DELETE SET NULL
    subs_welcome_url                    VARCHAR( 255 ),
    subs_welcome_rwt                    bool default false,
                                       
    srcdomain_id                        smallint, -- REFERENCES "srcdomain" ON DELETE SET NULL
                                       
    description                         TEXT,
                                       
    postback                            bool,
    postback_url                        VARCHAR( 256 ),
    postback_method                     char(1), -- "G" for get, "P" for post
    postback_pending                    bool,
    postback_condition                  TEXT,
    postback_expression                 TEXT,
                                       
    email_notification                  bool,
    email_template_id                   smallint,
    email_to                            VARCHAR( 128 ),
    email_cc                            VARCHAR( 128 ),
    email_bcc                           VARCHAR( 128 ),
    email_condition                     TEXT,
    email_pending                       bool,

    pending_if_duplicate_subscriber     bool default false,
    pending_if_duplicate_subscription   bool default true,
                                            
    preserve_subscriber                 bool default false,

    preprocess                          TEXT
);


--  conversion - таблица конверсий (заказов) с информацией каким образом каждая конверсия
--  была "отослана" (referred) изначально: через какой баннер, каким паблишером, 
--  какой кампанией; каким кодом трассировки оттрассированна и т.д.
--  paid** поля хранящие информацию об оплате коммисионных паблишеру, который
--  прислал конверсию. 

CREATE TABLE conversion (
    id                                  int auto_increment primary key,
    status                              tinyint default 1,
    created_date                        datetime,
    craeted_ip                          varchar( 32 ) default '0.0.0.0',
    updated_date                        datetime,
    conversion_code_id                  smallINT,  --  references conversion ON DELETE SET NULL
    custom_id                           VARCHAR( 64 ),
    type_id                             tinyint NOT NULL DEFAULT 1,
    amount                              DOUBLE default 0.00,
    click_date                          datetime,
    click_url_id                        INT, -- REFERENCES url ON DELETE SET NULL,
    click_custom                        varchar( 128 ),
    click_creative_id                   INT, -- REFERENCES creative ON DELETE SET NULL,
    click_banner_id                     INT, -- REFERENCES banner ON DELETE SET NULL,
    campaign_id                         smallint, -- REFERENCES campaign ON DELETE SET NULL,
    publisher_id                        INT, -- REFERENCES publisher ON DELETE SET NULL,
    subscriber_id                       INT, -- REFERENCES subscriber ON DELETE SET NULL,
    paid                                bool default false,
    paid_date                           datetime,
    paid_commission                     float default 0.00,
    comment                             VARCHAR( 128 ),
    index (custom_id)
);                                      
                                        

--  таблица подписчиков. основные поля - это ид подписчика и его почтовый адрес,
--  неявно закодированные через id домена и user (левой части почтового адреса);
--  0 статус - неактивный подписчик
--  1 активный
--  3 приостановленный так как было получено сильно много bounces при послке ему писем
--  9 административно заблокированный - система никогда не шлет таким подписчикам письма                                        
--  имя, адрес и пр. детали подписчика
--  custom** - поля для хранения произвольной информации
--  conversion_id - ид конверсии через которую данный подписчик попал в систему.

create table subscriber (
    id                                  int auto_increment primary key,
    status                              tinyint default 1,
    user                                varchar(64) not null,
    domain_id                           int REFERENCES domain ON DELETE cascade,
    conversion_id                       smallint, --  references conversion ON DELETE SET NULL
    bounces                             tinyint default 0,
    signup                              datetime,
    signup_ip                           varchar(32) default '0.0.0.0',
    modify                              datetime,
    modify_ip                           varchar(32) default '0.0.0.0',
    unsubscribe                         datetime,
    unsubscribe_ip                      varchar(32) default '0.0.0.0',
    first_name                          varchar(64) default '',
    last_name                           varchar(64) default '',
    address1                            varchar(64) default '',
    address2                            varchar(64) default '',
    city                                varchar(64) default '',
    state_id                            smallint,
    region                              VARCHAR( 16 ) default '',
    zip                                 varchar(16) default '',
    country_id                          smallint,
    birthday                            date,
    phone1                              varchar(32) default '',
    phone2                              varchar(32) default '',
    custom1                             varchar(64) default '',
    custom2                             varchar(64) default '',
    custom3                             varchar(64) default '',
    custom4                             varchar(64) default '',
    custom5                             varchar(64) default '',
    custom6                             varchar(64) default '',
    custom7                             varchar(64) default '',
    custom8                             varchar(64) default '',
    custom9                             varchar(64) default '',
    unique                              subscriber_email(domain_id,user)
);


-- табилца категорий ньюслистов

CREATE TABLE newslist_category (   
    id                                  smallint PRIMARY KEY auto_increment,
    status                              tinyint DEFAULT 1,
    name                                varchar(128) NOT NULL,
    description                         text,
    visible                             boolean default true
);


-- ньюслисты (для подписки подписчиками)
-- задаются параметры подписки-отписки (subs_** / unsubs_** ), имена кастом полей (custom***) и
-- через какой "домен отсылки" (srcdomain_id) шлются письма подписчикам ньюслиста

CREATE TABLE newslist (   
    id                                  smallint PRIMARY KEY auto_increment,
    status                              smallint DEFAULT 1,
    name                                varchar(128) UNIQUE NOT NULL,
    description                         varchar(256),
    url                                 varchar(256),
    visible                             boolean default true,
    category_id                         smallint, -- references newslist_category("id") on delete set NULL
    subs_confirm_over                   bool,
    subs_confirm                        boolean NOT NULL default true,
    subs_welcome_e_over                 bool,
    subs_welcome_e_id                   smallint, -- references t_template("id") on delete set NULL
    unsubs_confirm_over                 BOOL,
    unsubs_confirm                      boolean NOT NULL default true,
    unsubs_goodbye_e_id                 smallint, -- references t_template("id") on delete set NULL
    unsubs_goodbye_e_over               BOOL,
    srcdomain_id                        smallint, -- references t_srcdomain("id") on delete set NULL
    active_subscribers                  int DEFAULT 0 NOT NULL,
    blocked_subscribers                 int DEFAULT 0 NOT NULL,
    suspended_subscribers               int DEFAULT 0 NOT NULL,
    custom1_name                        varchar(32) default 'ncustom1',
    custom2_name                        varchar(32) default 'ncustom2',
    custom3_name                        varchar(32) default 'ncustom3'
);


-- таблица подписки - какой подписчик подписан на какой ньюслист
-- даты и ип подписки-модификации
-- значения статусов схоже с таблицей подписчиков
-- custom** -  поля для хранения произвольной информации о подписчике-подписке

create table subscription (
    subscriber_id                       int NOT NULL,
    newslist_id                         smallint NOT NULL,
    status                              tinyint DEFAULT 1,
    signup                              datetime,
    signup_ip                           varchar(32) default '0.0.0.0',
    modify                              datetime,
    modify_ip                           varchar(64) default '0.0.0.0',
    custom1                             varchar(64),
    custom2                             varchar(64),
    custom3                             varchar(64),
    primary key ( subscriber_id, newslist_id )
);

-- таблица серверов отсылки
-- srcdomain_id - отсылочный домен который обслуживает каждый relay
-- db_** параметры соединения с базой данных relay
CREATE TABLE relay (
    id                                  smallint primary key auto_increment,
    status                              tinyint  DEFAULT 1 NOT NULL,
    srcdomain_id                        smallint, -- references srcdomain("id") on delete set NULL
    db_host                             varchar(64) DEFAULT 'localhost' NOT NULL,
    db_name                             varchar(32) DEFAULT 'mail' NOT NULL,
    db_user                             varchar(32) DEFAULT 'mail' NOT NULL,
    db_password                         varchar(32) DEFAULT '' NOT NULL
);                                     


-- категории урлей
CREATE TABLE url_category (   
    id                                  smallint PRIMARY KEY auto_increment,
    status                              tinyint DEFAULT 1,
    name                                varchar(128) NOT NULL,
    description                         text,
    visible                             boolean default true
);


-- сами урли
CREATE TABLE url (
    id                                  int PRIMARY KEY auto_increment,
    status                              tinyint default 1,
    name                                VARCHAR( 64 ) NOT NULL,
    url                                 TEXT NOT NULL,
    url_category_id                     smallint, -- references url_category("id") on delete set NULL
    rewrite                             bool default false,
    description                         TEXT
);



-- категории creative
CREATE TABLE creative_category (   
    id                                  smallint PRIMARY KEY auto_increment,
    status                              tinyint DEFAULT 1,
    name                                varchar(128) NOT NULL,
    description                         text,
    visible                             boolean default true
);


-- creative - "креатив" - рекламный материал. может быть письмом, html страницей, и т.п.
CREATE TABLE creative (
    id                                  INT PRIMARY KEY auto_increment,
    type_id                             tinyint not null,
    name                                VARCHAR(64),
    private                             bool,
    description                         TEXT,
    creative_category_id                smallint, -- references creative_category("id") on delete set NULL

    subject                             TEXT,
    text                                TEXT,
    html                                TEXT,
    body_type                           CHAR(1) NOT NULL DEFAULT 'm' -- mime / plain text / html
);


-- категории баннеров
CREATE TABLE banner_category (   
    id                                  smallint PRIMARY KEY auto_increment,
    status                              tinyint DEFAULT 1,
    name                                varchar(128) NOT NULL,
    description                         text,
    visible                             boolean default true
);


-- баннера
CREATE TABLE banner (
    id                                  INT PRIMARY KEY auto_increment,
    name                                VARCHAR(64),
    description                         TEXT,
    url_id                              INT, -- REFERENCES url
    banner_category_id                  smallint, -- references banner_category("id") on delete set NULL
--    dimension_id                      smallint REFERENCES dimension,
    image_file                          VARCHAR( 32 ),
    image_url                           VARCHAR( 128 ),
    rich_media                          bool default false,
    alt_text                            VARCHAR( 128 ),
    target                              VARCHAR( 32 )
);


-- задачи на отсылку писем - задается какой креатив посылается, когда,
-- в какой ньюслст, с какими параметрами, дополнительные критерии выбора подписчиков,
-- статистические данные сколько отослано, сколько bounced, и т.п.
CREATE TABLE task (
    id                                  int primary key auto_increment,
    status                              tinyint DEFAULT 1,
    newslist_id                         smallint NOT NULL, -- references newslist("id") on delete cascade,

    creative_id                         int NOT NULL, -- references creative("id") on delete set null,

    from_email                          varchar(128),
    from_name                           varchar(128),
    to_name                             varchar(128),

    start                               datetime NOT NULL,

    filter                              text, -- base64( Storable::freeze( \%filter ) )

    s_queued                            int DEFAULT 0,
    s_sent                              int DEFAULT 0,
    s_deferred                          int DEFAULT 0,
    s_opened                            int DEFAULT 0,
    s_bounced                           int DEFAULT 0,
    s_unsubscribed                      int DEFAULT 0,
    s_ordered                           int DEFAULT 0,
    index (start)
);


-- таблица отсылки - списки подписчиков для задачей по отправке, через какой сервер отсылалось,
-- детали и статус отправки
create table mailing (
    subscriber_id                       int NOT NULL,
    task_id                             int NOT NULL,
    status                              smallint DEFAULT 0,
    relay_id                            smallint DEFAULT 0,
    date                                date,
    primary key ( subscriber_id, task_id  )
);

-- группы паблишров - каждый паблишер принадлежит к какой то одной группе -
-- для удобства манипулирования паблишерами и настроек комиссионных
CREATE TABLE publisher_group (   
    id                                  smallint PRIMARY KEY auto_increment,
    status                              tinyint DEFAULT 1,
    name                                varchar(128) NOT NULL,
    description                         text
);

-- паблишер - человек / компания которая размещает рекламу на своем сайте или другим методом;
-- получает вознаграждение от владельца системы, согласно комисионным настройкам 
-- (может быть за клики, за показы баннеров или за конверсии)
CREATE TABLE publisher (
    id                                  INT PRIMARY KEY auto_increment,
    status                              tinyint default 1,

    signup                              datetime,

    login                               VARCHAR( 32 ) UNIQUE NOT NULL,
    password                            CHAR( 32 ) NOT NULL,

    email                               VARCHAR( 64 ) NOT NULL,

    publisher_group_id                  smallINT NOT NULL,

    company                             VARCHAR( 64 ),
    fname                               VARCHAR( 32 ),
    lname                               VARCHAR( 32 ) NOT NULL,

    address1                            VARCHAR( 64 ) NOT NULL,
    address2                            VARCHAR( 64 ),
    city                                VARCHAR( 32 ) NOT NULL,
    state_id                            smallINT,
    region                              VARCHAR( 16 ),
    zip                                 VARCHAR( 16 ) NOT NULL,
    country_id                          smallINT,
    phone1                              VARCHAR( 32 ) NOT NULL,
    phone2                              VARCHAR( 32 ) NOT NULL,
    fax                                 VARCHAR( 32 ),

    pay_to                              VARCHAR( 32 ),

    custom_0                            VARCHAR( 128 ),
    custom_1                            VARCHAR( 128 ),
    custom_2                            VARCHAR( 128 ),
    custom_3                            VARCHAR( 128 ),
    custom_4                            VARCHAR( 128 ),
    custom_5                            VARCHAR( 128 ),
    custom_6                            VARCHAR( 128 ),
    custom_7                            VARCHAR( 128 ),
    custom_8                            VARCHAR( 128 ),
    custom_9                            VARCHAR( 128 ),

    comment                             TEXT
);


-- таблица регистрации кликов 
CREATE TABLE clicks (
    date                                DATE NOT NULL,
    url_id                              INT NOT NULL DEFAULT 0, -- REFERENCES url
    campaign_id                         smallint NOT NULL DEFAULT 0, -- REFERENCES campaign
    publisher_id                        INT NOT NULL DEFAULT 0, -- REFERENCES affiliation
    banner_id                           INT NOT NULL DEFAULT 0, -- REFERENCES banner
    creative_id                         INT NOT NULL DEFAULT 0, -- REFERENCES creative
    task_id                             INT NOT NULL DEFAULT 0, -- REFERENCES task

    count_total                         int default 0,
    count_unique                        int default 0,

    paid                                bool default false,
    paid_date                           date,
    paid_commission                     float default 0.00,

    PRIMARY KEY(
        date,
        url_id,
        campaign_id,
        publisher_id,
        banner_id,
        creative_id,
        task_id
   )
);


-- таблица рекламных кампаний, описывает дату старта-остановки, 
-- умолчательные комиссионные настройки
--

CREATE TABLE campaign (
    id                                  smallint PRIMARY KEY auto_increment,
    status                              tinyint default 1,
    name                                VARCHAR( 128 ),

    start_date                          DATE,
    end_date                            DATE,

    -- campaign setup cost
    setup_cost                          DOUBLE PRECISION NOT NULL DEFAULT 0,

    -- cost per thousand impressions
    rpm                                 DOUBLE PRECISION NOT NULL DEFAULT 0,
    -- cost per click
    rpc                                 DOUBLE PRECISION NOT NULL DEFAULT 0,

    -- default RPAs
    rpa_sale                            DOUBLE PRECISION NOT NULL DEFAULT 0,
    rpa_sale_is_percent                 bool default true,

    rpa_lead                            DOUBLE PRECISION NOT NULL DEFAULT 0,
    rpa_lead_is_percent                 bool default true,

    rpa_rebill                          DOUBLE PRECISION NOT NULL DEFAULT 0,
    rpa_rebill_is_percent               bool default true,

    description                         TEXT

);

-- таблица "назначений" какие кампании доступны каким группам паблишеров.
-- отсутствие записи в этой таблице говорит о том, что паблишер из такой группы
-- не имеет доступа к соответствующей кампании. так же есть возможность
-- переназначить умолчательные комисионные конкретной группе на конкретную кампанию.
--

create table campaign_publisher_group (
    campaign_id                         smallint NOT NULL,
    publisher_group_id                  smallint NOT NULL,

    rpm_default                         bool default true,
    rpm                                 DOUBLE PRECISION NOT NULL DEFAULT 0,

    rpc_default                         bool default true,
    rpc                                 DOUBLE PRECISION NOT NULL DEFAULT 0,

    rpa_sale_default                    bool default true,
    rpa_sale                            DOUBLE PRECISION NOT NULL DEFAULT 0,
    rpa_sale_is_percent                 bool default true,

    rpa_lead_default                    bool default true,
    rpa_lead                            DOUBLE PRECISION NOT NULL DEFAULT 0,
    rpa_lead_is_percent                 bool default true,

    rpa_rebill_default                  bool default true,
    rpa_rebill                          DOUBLE PRECISION NOT NULL DEFAULT 0,
    rpa_rebill_is_percent               bool default true,

    PRIMARY KEY(
        campaign_id,
        publisher_group_id
   )
);


-- таблица статистики по боунсам
-- сколько боунсов получено за каждый день для каждого домена с различным боунс кодом 
--
create table bounce_report (
    date                                date not NULL,
    domain_id                           int NOT NULL,
    relay_id                            smallint NOT NULL,
    counter                             int NOT NULL default 0,
    code                                smallint NOT NULL default 0,
    reason                              character varying(128) NOT NULL,
    primary key ( domain_id, code, date, relay_id )
);


