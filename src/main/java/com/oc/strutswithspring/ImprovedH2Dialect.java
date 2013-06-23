package com.oc.strutswithspring;

import org.hibernate.dialect.H2Dialect;

/**
 * This is just a workaround to avoid error log message when using H2 DB in in-memory mode.
 *
 * @see <a href="https://hibernate.atlassian.net/browse/HHH-7002">SchemaExport ERROR when using in-memory database</a>
 */
public class ImprovedH2Dialect extends H2Dialect {

    @Override
    public String getDropSequenceString(String sequenceName) {
        // Adding the "if exists" clause to avoid warnings
        return "drop sequence if exists " + sequenceName;
    }

    @Override
    public boolean dropConstraints() {
        // We don't need to drop constraints before dropping tables, that just leads to error
        // messages about missing tables when we don't have a schema in the database
        return false;
    }
}
