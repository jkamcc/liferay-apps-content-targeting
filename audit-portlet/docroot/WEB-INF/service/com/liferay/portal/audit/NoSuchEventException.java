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

package com.liferay.portal.audit;

import com.liferay.portal.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchEventException extends NoSuchModelException {

	public NoSuchEventException() {
		super();
	}

	public NoSuchEventException(String msg) {
		super(msg);
	}

	public NoSuchEventException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchEventException(Throwable cause) {
		super(cause);
	}

}