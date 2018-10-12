package reflection.main;


import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.StringJoiner;

public class QueryGenerator {
    public String getAll(Class<?> clazz) {
        Table tableAnnotation = clazz.getAnnotation(Table.class);
        if (tableAnnotation == null) {
            throw new IllegalArgumentException("annotation @Table is missing");
        }

        String tableName = tableAnnotation.name().isEmpty() ?
                clazz.getName() :
                tableAnnotation.name();

        StringBuilder sqlQuery = new StringBuilder("SELECT ");

        StringJoiner columnNamesJoiner = new StringJoiner(", ");
        for (Field field : clazz.getDeclaredFields()) {
            Column columnAnnotation = field.getAnnotation(Column.class);
            if (columnAnnotation != null) {
                String columnName = columnAnnotation.name().isEmpty() ?
                        field.getName() :
                        columnAnnotation.name();
                columnNamesJoiner.add(columnName);
            }
        }

        sqlQuery.append(columnNamesJoiner);
        sqlQuery.append(" FROM ");
        sqlQuery.append(tableName);
        sqlQuery.append(";");
        return sqlQuery.toString();
    }

    public String insert(Object value) throws IllegalAccessException {
        Class<?> clazz = value.getClass();
        Table tableAnnotation = clazz.getAnnotation(Table.class);
        if (tableAnnotation == null) {
            throw new IllegalArgumentException("annotation @Table is missing");
        }

        String tableName = tableAnnotation.name().isEmpty() ?
                clazz.getName() :
                tableAnnotation.name();

        StringBuilder sqlQuery = new StringBuilder("INSERT INTO ");
        sqlQuery.append(tableName);
        //sqlQuery.append(" (");
        StringJoiner columnNamesJoiner = new StringJoiner(", "," (",") ");
        StringJoiner columnNamesJoinerValues = new StringJoiner(", "," (",")");
        for (Field field : clazz.getDeclaredFields()) {
            Column columnAnnotation = field.getAnnotation(Column.class);
            if (columnAnnotation != null) {
                String columnName = columnAnnotation.name().isEmpty() ?
                        field.getName() :
                        columnAnnotation.name();
                columnNamesJoiner.add(columnName);
                field.setAccessible(true);
                columnNamesJoinerValues.add(field.get(value).toString());
                field.setAccessible(false);
            }
        }
        sqlQuery.append(columnNamesJoiner);
        sqlQuery.append("VALUES ");
        sqlQuery.append(columnNamesJoinerValues);
        sqlQuery.append(";");

        return sqlQuery.toString();
    }

    public String getById(Class<?> clazz, Object id) {
        Table tableAnnotation = clazz.getAnnotation(Table.class);
        if (tableAnnotation == null) {
            throw new IllegalArgumentException("annotation @Table is missing");
        }

        String tableName = tableAnnotation.name().isEmpty() ?
                clazz.getName() :
                tableAnnotation.name();

        StringBuilder sqlQuery = new StringBuilder("SELECT ");
        String idColomn = "";
        StringJoiner columnNamesJoiner = new StringJoiner(", ");
        for (Field field : clazz.getDeclaredFields()) {
            Column columnAnnotation = field.getAnnotation(Column.class);
            ID idAnnotation = field.getAnnotation(ID.class);
            if (columnAnnotation != null) {
                if(idAnnotation == null){
                String columnName = columnAnnotation.name().isEmpty() ?
                        field.getName() :
                        columnAnnotation.name();
                columnNamesJoiner.add(columnName);
                } else{
                    idColomn = columnAnnotation.name().isEmpty() ?
                            field.getName() :
                            columnAnnotation.name();
                }
            }
        }
        sqlQuery.append(columnNamesJoiner);
        sqlQuery.append(" FROM ");
        sqlQuery.append(tableName);
        sqlQuery.append(" WHERE ");
        sqlQuery.append(idColomn+" = ");
        sqlQuery.append(id);
        sqlQuery.append(";");
        return sqlQuery.toString();
    }

    public String delete(Class clazz, Object id) {
        return null;
    }
}