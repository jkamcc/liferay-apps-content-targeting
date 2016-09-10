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

package com.liferay.portal.audit.hook.security.auth;

import com.liferay.portal.audit.util.EventTypes;
import com.liferay.portal.kernel.audit.AuditException;
import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.audit.AuditRouterUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AuthFailure;
import com.liferay.portal.service.UserLocalServiceUtil;

import java.util.Map;

/**
 * @author Bruno Farache
 * @author Mika Koivisto
 * @author Brian Wing Shun Chan
 */
public class LoginFailure implements AuthFailure {


	public void onFailureByEmailAddress(
		long companyId, String emailAddress, Map<String, String[]> headerMap,
		Map<String, String[]> parameterMap) {

		try {
			User user = UserLocalServiceUtil.getUserByEmailAddress(
				companyId, emailAddress);

			AuditMessage auditMessage = buildAuditMessage(
				user, headerMap, "Failed to authenticate by email address");

			AuditRouterUtil.route(auditMessage);
		}
		catch (AuditException ae) {
			if (_log.isWarnEnabled()) {
				_log.warn("Unable to route audit message", ae);
			}
		}
		catch (Exception e) {
		}
	}


	public void onFailureByScreenName(
		long companyId, String screenName, Map<String, String[]> headerMap,
		Map<String, String[]> parameterMap) {

		try {
			User user = UserLocalServiceUtil.getUserByScreenName(
				companyId, screenName);

			AuditMessage auditMessage = buildAuditMessage(
				user, headerMap, "Failed to authenticate by screen name");

			AuditRouterUtil.route(auditMessage);
		}
		catch (AuditException ae) {
			if (_log.isWarnEnabled()) {
				_log.warn("Unable to route audit message", ae);
			}
		}
		catch (Exception e) {
		}
	}


	public void onFailureByUserId(
		long companyId, long userId, Map<String, String[]> headerMap,
		Map<String, String[]> parameterMap) {

		try {
			User user = UserLocalServiceUtil.getUserById(companyId, userId);

			AuditMessage auditMessage = buildAuditMessage(
				user, headerMap, "Failed to authenticate by user id");

			AuditRouterUtil.route(auditMessage);
		}
		catch (AuditException ae) {
			if (_log.isWarnEnabled()) {
				_log.warn("Unable to route audit message", ae);
			}
		}
		catch (Exception e) {
		}
	}

	protected AuditMessage buildAuditMessage(
		User user, Map<String, String[]> headerMap, String reason) {

		JSONObject additionalInfo = JSONFactoryUtil.createJSONObject();

		additionalInfo.put("headers", JSONFactoryUtil.serialize(headerMap));
		additionalInfo.put("reason", reason);

		AuditMessage auditMessage = new AuditMessage(
			EventTypes.LOGIN_FAILURE, user.getCompanyId(), user.getUserId(),
			user.getFullName(), User.class.getName(),
			String.valueOf(user.getPrimaryKey()), null, additionalInfo);

		return auditMessage;
	}

	private static Log _log = LogFactoryUtil.getLog(LoginFailure.class);

}