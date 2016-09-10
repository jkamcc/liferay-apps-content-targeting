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

package com.liferay.portal.audit.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the AuditEvent service. Represents a row in the &quot;Audit_AuditEvent&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AuditEventModel
 * @see com.liferay.portal.audit.model.impl.AuditEventImpl
 * @see com.liferay.portal.audit.model.impl.AuditEventModelImpl
 * @generated
 */
public interface AuditEvent extends AuditEventModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.portal.audit.model.impl.AuditEventImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
}