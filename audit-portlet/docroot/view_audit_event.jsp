<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

long auditEventId = ParamUtil.getLong(request, "auditEventId");

AuditEvent auditEvent = null;

String eventTypeAction = StringPool.BLANK;

if (auditEventId > 0) {
	auditEvent = AuditEventLocalServiceUtil.fetchAuditEvent(auditEventId);

	eventTypeAction = (String)PortalClassInvoker.invoke(false, new MethodKey(ClassResolverUtil.resolve("com.liferay.portal.security.permission.ResourceActionsUtil", PortalClassLoaderUtil.getClassLoader()), "getAction", PageContext.class, String.class), pageContext, auditEvent.getEventType());
}
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	localizeTitle="<%= (auditEvent == null) %>"
	title='<%= (auditEvent == null) ? "audit-event" : auditEvent.getEventType() + " (" + eventTypeAction + ")" %>'
/>

<c:choose>
	<c:when test="<%= auditEvent == null %>">
		<div class="portlet-msg-error">
			<liferay-ui:message key="the-event-could-not-be-found" />
		</div>
	</c:when>
	<c:otherwise>
		<aui:column columnWidth="350">
			<aui:field-wrapper label="event-id">
				<%= auditEvent.getAuditEventId() %>
			</aui:field-wrapper>

			<aui:field-wrapper label="create-date">
				<%= dateFormatDateTime.format(auditEvent.getCreateDate()) %>
			</aui:field-wrapper>

			<aui:field-wrapper label="resource-id">
				<%= auditEvent.getClassPK() %>
			</aui:field-wrapper>

			<aui:field-wrapper label="resource-name">
				<%= (String)PortalClassInvoker.invoke(false, new MethodKey(ClassResolverUtil.resolve("com.liferay.portal.security.permission.ResourceActionsUtil", PortalClassLoaderUtil.getClassLoader()), "getModelResource", PageContext.class, String.class), pageContext, auditEvent.getClassName()) %>

				(<%= auditEvent.getClassName() %>)
			</aui:field-wrapper>

			<aui:field-wrapper label="resource-action">
				<%= eventTypeAction %>

				(<%= auditEvent.getEventType() %>)
			</aui:field-wrapper>
		</aui:column>
		<aui:column>
			<aui:field-wrapper label="user-id">
				<%= auditEvent.getUserId() %>
			</aui:field-wrapper>

			<aui:field-wrapper label="user-name">
				<%= auditEvent.getUserName() %>
			</aui:field-wrapper>

			<aui:field-wrapper label="client-host">
				<%= Validator.isNotNull(auditEvent.getClientHost()) ? auditEvent.getClientHost() : LanguageUtil.get(pageContext, "none") %>
			</aui:field-wrapper>

			<aui:field-wrapper label="client-ip">
				<%= Validator.isNotNull(auditEvent.getClientIP()) ? auditEvent.getClientIP() : LanguageUtil.get(pageContext, "none") %>
			</aui:field-wrapper>

			<aui:field-wrapper label="server-name">
				<%= Validator.isNotNull(auditEvent.getServerName()) ? auditEvent.getServerName() : LanguageUtil.get(pageContext, "none") %>
			</aui:field-wrapper>

			<aui:field-wrapper label="session-id">
				<%= Validator.isNotNull(auditEvent.getSessionID()) ? auditEvent.getSessionID() : LanguageUtil.get(pageContext, "none") %>
			</aui:field-wrapper>

			<aui:field-wrapper label="additional-information">
				<%= Validator.isNotNull(auditEvent.getAdditionalInfo()) ? auditEvent.getAdditionalInfo() : LanguageUtil.get(pageContext, "none") %>
			</aui:field-wrapper>
		</aui:column>
	</c:otherwise>
</c:choose>