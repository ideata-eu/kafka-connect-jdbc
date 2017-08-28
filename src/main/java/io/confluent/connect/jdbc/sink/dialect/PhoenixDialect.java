package io.confluent.connect.jdbc.sink.dialect;

import java.util.Collection;

import static io.confluent.connect.jdbc.sink.dialect.StringBuilderUtil.joinToBuilder;
import static io.confluent.connect.jdbc.sink.dialect.StringBuilderUtil.nCopiesToBuilder;

public class PhoenixDialect extends DbDialect {
    public PhoenixDialect(){
        super("\"", "\"");
    }

    public String getUpsertQuery(final String table, final Collection<String> keyCols, final Collection<String> cols) {
        final StringBuilder builder = new StringBuilder();
        builder.append("UPSERT INTO ");
        builder.append(table);
        builder.append(" (");
        joinToBuilder(builder, ",", keyCols, cols, identity());
        builder.append(") VALUES (");
        nCopiesToBuilder(builder, ",", "?", cols.size() + keyCols.size());
        builder.append(")");
        return builder.toString();
    }
}
