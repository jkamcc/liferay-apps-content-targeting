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
import com.liferay.portal.audit.service.AuditEventLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the AuditEvent service. Represents a row in the &quot;Audit_AuditEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AuditEventImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEventImpl
 * @see com.liferay.portal.audit.model.AuditEvent
 * @generated
 */
public abstract class AuditEventBaseImpl extends AuditEventModelImpl
	implements AuditEvent {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a audit event model instance should use the {@link AuditEvent} interface instead.
	 */

	public void persist() throws SystemException {
		if (this.isNew()) {
			AuditEventLocalServiceUtil.addAuditEvent(this);
		}
		else {
			AuditEventLocalServiceUtil.updateAuditEvent(this);
		}
	}
}