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

package com.liferay.portal.audit.service.persistence;

import com.liferay.portal.audit.model.AuditEvent;
import com.liferay.portal.audit.service.AuditEventLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class AuditEventActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public AuditEventActionableDynamicQuery() throws SystemException {
		setBaseLocalService(AuditEventLocalServiceUtil.getService());
		setClass(AuditEvent.class);

		setClassLoader(com.liferay.portal.audit.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("auditEventId");
	}
}