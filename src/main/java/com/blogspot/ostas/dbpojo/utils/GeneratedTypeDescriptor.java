package com.blogspot.ostas.dbpojo.utils;

public class GeneratedTypeDescriptor {
    private String typeName;
    private String importString;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getImportString() {
        return importString;
    }

    public void setImportString(String importString) {
        this.importString = importString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeneratedTypeDescriptor that = (GeneratedTypeDescriptor) o;

        if (importString != null ? !importString.equals(that.importString) : that.importString != null) return false;
        return !(typeName != null ? !typeName.equals(that.typeName) : that.typeName != null);

    }

    @Override
    public int hashCode() {
        int result = typeName != null ? typeName.hashCode() : 0;
        result = 31 * result + (importString != null ? importString.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GeneratedTypeDescriptor{" +
                "typeName='" + typeName + '\'' +
                ", importString='" + importString + '\'' +
                '}';
    }
}
