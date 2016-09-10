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

package com.liferay.portal.audit.util;

/**
 * @author Brian Wing Shun Chan
 */
public interface EventTypes {

	public static final String ADD = "ADD";

	public static final String ASSIGN = "ASSIGN";

	public static final String DELETE = "DELETE";

	public static final String IMPERSONATE = "IMPERSONATE";

	public static final String LOGIN = "LOGIN";

	public static final String LOGIN_FAILURE = "LOGIN_FAILURE";

	public static final String LOGOUT = "LOGOUT";

	public static final String UNASSIGN = "UNASSIGN";

	public static final String UPDATE = "UPDATE";

}