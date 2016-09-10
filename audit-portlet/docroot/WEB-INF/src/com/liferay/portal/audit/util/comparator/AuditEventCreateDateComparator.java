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

package com.liferay.portal.audit.util.comparator;

import com.liferay.portal.audit.model.AuditEvent;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author Brian Wing Shun Chan
 */
public class AuditEventCreateDateComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "createDate ASC";

	public static final String ORDER_BY_DESC = "createDate DESC";

	public static final String[] ORDER_BY_FIELDS = {"createDate"};

	public AuditEventCreateDateComparator() {
		this(false);
	}

	public AuditEventCreateDateComparator(boolean ascending) {
		_ascending = ascending;
	}


	public int compare(Object obj1, Object obj2) {
		AuditEvent auditEvent1 = (AuditEvent)obj1;
		AuditEvent auditEvent2 = (AuditEvent)obj2;

		int value = DateUtil.compareTo(
			auditEvent1.getCreateDate(), auditEvent2.getCreateDate());

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}


	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}


	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}


	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}