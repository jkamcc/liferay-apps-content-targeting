/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the applicable 
 * Liferay software end user license agreement ("License Agreement")
 * found on www.liferay.com/legal/eulas. You may also contact Liferay, Inc.
 * for a copy of the License Agreement. You may not use this file except in
 * compliance with the License Agreement. 
 * See the License Agreement for the specific language governing
 * permissions and limitations under the License Agreement, including 
 * but not limited to distribution rights of the Software.
 *
 */

package com.liferay.portal.audit.model.impl;

import com.liferay.portal.audit.model.AuditEvent;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AuditEvent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AuditEvent
 * @generated
 */
public class AuditEventCacheModel implements CacheModel<AuditEvent>,
	Externalizable {

	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{auditEventId=");
		sb.append(auditEventId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", message=");
		sb.append(message);
		sb.append(", clientHost=");
		sb.append(clientHost);
		sb.append(", clientIP=");
		sb.append(clientIP);
		sb.append(", serverName=");
		sb.append(serverName);
		sb.append(", serverPort=");
		sb.append(serverPort);
		sb.append(", sessionID=");
		sb.append(sessionID);
		sb.append(", additionalInfo=");
		sb.append(additionalInfo);
		sb.append("}");

		return sb.toString();
	}


	public AuditEvent toEntityModel() {
		AuditEventImpl auditEventImpl = new AuditEventImpl();

		auditEventImpl.setAuditEventId(auditEventId);
		auditEventImpl.setCompanyId(companyId);
		auditEventImpl.setUserId(userId);

		if (userName == null) {
			auditEventImpl.setUserName(StringPool.BLANK);
		}
		else {
			auditEventImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			auditEventImpl.setCreateDate(null);
		}
		else {
			auditEventImpl.setCreateDate(new Date(createDate));
		}

		if (eventType == null) {
			auditEventImpl.setEventType(StringPool.BLANK);
		}
		else {
			auditEventImpl.setEventType(eventType);
		}

		if (className == null) {
			auditEventImpl.setClassName(StringPool.BLANK);
		}
		else {
			auditEventImpl.setClassName(className);
		}

		if (classPK == null) {
			auditEventImpl.setClassPK(StringPool.BLANK);
		}
		else {
			auditEventImpl.setClassPK(classPK);
		}

		if (message == null) {
			auditEventImpl.setMessage(StringPool.BLANK);
		}
		else {
			auditEventImpl.setMessage(message);
		}

		if (clientHost == null) {
			auditEventImpl.setClientHost(StringPool.BLANK);
		}
		else {
			auditEventImpl.setClientHost(clientHost);
		}

		if (clientIP == null) {
			auditEventImpl.setClientIP(StringPool.BLANK);
		}
		else {
			auditEventImpl.setClientIP(clientIP);
		}

		if (serverName == null) {
			auditEventImpl.setServerName(StringPool.BLANK);
		}
		else {
			auditEventImpl.setServerName(serverName);
		}

		auditEventImpl.setServerPort(serverPort);

		if (sessionID == null) {
			auditEventImpl.setSessionID(StringPool.BLANK);
		}
		else {
			auditEventImpl.setSessionID(sessionID);
		}

		if (additionalInfo == null) {
			auditEventImpl.setAdditionalInfo(StringPool.BLANK);
		}
		else {
			auditEventImpl.setAdditionalInfo(additionalInfo);
		}

		auditEventImpl.resetOriginalValues();

		return auditEventImpl;
	}


	public void readExternal(ObjectInput objectInput) throws IOException {
		auditEventId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		eventType = objectInput.readUTF();
		className = objectInput.readUTF();
		classPK = objectInput.readUTF();
		message = objectInput.readUTF();
		clientHost = objectInput.readUTF();
		clientIP = objectInput.readUTF();
		serverName = objectInput.readUTF();
		serverPort = objectInput.readInt();
		sessionID = objectInput.readUTF();
		additionalInfo = objectInput.readUTF();
	}


	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(auditEventId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);

		if (eventType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventType);
		}

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		if (classPK == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(classPK);
		}

		if (message == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(message);
		}

		if (clientHost == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(clientHost);
		}

		if (clientIP == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(clientIP);
		}

		if (serverName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serverName);
		}

		objectOutput.writeInt(serverPort);

		if (sessionID == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sessionID);
		}

		if (additionalInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(additionalInfo);
		}
	}

	public long auditEventId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public String eventType;
	public String className;
	public String classPK;
	public String message;
	public String clientHost;
	public String clientIP;
	public String serverName;
	public int serverPort;
	public String sessionID;
	public String additionalInfo;
}