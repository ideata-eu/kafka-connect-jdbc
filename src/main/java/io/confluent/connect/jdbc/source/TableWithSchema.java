/**
 * Copyright 2015 Confluent Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package io.confluent.connect.jdbc.source;

public class TableWithSchema {
  private String tableName;
  private String tableSchema;

  public TableWithSchema(String tableSchema, String tableName) {
    this.tableName = tableName;
    this.tableSchema = tableSchema;
  }
  public String getTableSchema() {
    return tableSchema;
  }
  public void setTableSchema(String tableSchema) {
    this.tableSchema = tableSchema;
  }
  public String getTableName() {
    return tableName;
  }
  public void setTableName(String tableName) {
    this.tableName = tableName;
  }

  @Override
  public String toString() {
    return  tableSchema == null ? "" : tableSchema  + "." + tableName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TableWithSchema that = (TableWithSchema) o;

    if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
    return tableSchema != null ? tableSchema.equals(that.tableSchema) : that.tableSchema == null;
  }

  @Override
  public int hashCode() {
    int result = tableName != null ? tableName.hashCode() : 0;
    result = 31 * result + (tableSchema != null ? tableSchema.hashCode() : 0);
    return result;
  }
}
