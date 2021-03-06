/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.code.or.binlog.impl.event;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.google.code.or.binlog.BinlogEventV4Header;
import com.google.code.or.binlog.StatusVariable;
import com.google.code.or.common.glossary.column.StringColumn;
import com.google.code.or.common.util.MySQLConstants;

/**
 * 
 * @author Jingqi Xu
 */
public final class QueryEvent extends AbstractBinlogEventV4 {
	//
	public static final int EVENT_TYPE = MySQLConstants.QUERY_EVENT;
	
	//
	private long threadId;
	private long elapsedTime;
	private int databaseNameLength;
	private int errorCode;
	private int statusVariablesLength;
	private List<StatusVariable> statusVariables;
	private StringColumn databaseName;
	private StringColumn sql;
	
	/**
	 * 
	 */
	public QueryEvent() {
	}
	
	public QueryEvent(BinlogEventV4Header header) {
		this.header = header;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		.append("header", header)
		.append("threadId", threadId)
		.append("elapsedTime", elapsedTime)
		.append("databaseNameLength", databaseNameLength)
		.append("errorCode", errorCode)
		.append("statusVariablesLength", statusVariablesLength)
		.append("statusVariables", statusVariables)
		.append("databaseName", databaseName)
		.append("sql", sql).toString();
	}
	
	/**
	 * 
	 */
	public long getThreadId() {
		return threadId;
	}

	public void setThreadId(long threadId) {
		this.threadId = threadId;
	}

	public long getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public int getDatabaseNameLength() {
		return databaseNameLength;
	}

	public void setDatabaseNameLength(int databaseNameLength) {
		this.databaseNameLength = databaseNameLength;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getStatusVariablesLength() {
		return statusVariablesLength;
	}

	public void setStatusVariablesLength(int statusVariableLength) {
		this.statusVariablesLength = statusVariableLength;
	}

	public List<StatusVariable> getStatusVariables() {
		return statusVariables;
	}

	public void setStatusVariables(List<StatusVariable> statusVariables) {
		this.statusVariables = statusVariables;
	}

	public StringColumn getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(StringColumn databaseName) {
		this.databaseName = databaseName;
	}

	public StringColumn getSql() {
		return sql;
	}

	public void setSql(StringColumn sql) {
		this.sql = sql;
	}
}
