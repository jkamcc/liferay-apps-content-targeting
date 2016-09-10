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

<liferay-portlet:renderURL varImpl="searchURL" />

<aui:form action="<%= searchURL %>" method="get" name="fm">
	<liferay-portlet:renderURLParams varImpl="searchURL" />

	<liferay-portlet:renderURL varImpl="iteratorURL">
		<portlet:param name="className" value="<%= className %>" />
		<portlet:param name="classPK" value="<%= classPK %>" />
		<portlet:param name="clientHost" value="<%= clientHost %>" />
		<portlet:param name="clientIP" value="<%= clientIP %>" />
		<portlet:param name="endDateAmPm" value="<%= String.valueOf(endDateAmPm) %>" />
		<portlet:param name="endDateDay" value="<%= String.valueOf(endDateDay) %>" />
		<portlet:param name="endDateHour" value="<%= String.valueOf(endDateHour) %>" />
		<portlet:param name="endDateMinute" value="<%= String.valueOf(endDateMinute) %>" />
		<portlet:param name="endDateMonth" value="<%= String.valueOf(endDateMonth) %>" />
		<portlet:param name="endDateYear" value="<%= String.valueOf(endDateYear) %>" />
		<portlet:param name="eventType" value="<%= eventType %>" />
		<portlet:param name="serverName" value="<%= serverName %>" />
		<portlet:param name="serverPort" value="<%= String.valueOf(serverPort) %>" />
		<portlet:param name="sessionID" value="<%= sessionID %>" />
		<portlet:param name="startDateAmPm" value="<%= String.valueOf(startDateAmPm) %>" />
		<portlet:param name="startDateDay" value="<%= String.valueOf(startDateDay) %>" />
		<portlet:param name="startDateHour" value="<%= String.valueOf(startDateHour) %>" />
		<portlet:param name="startDateMinute" value="<%= String.valueOf(startDateMinute) %>" />
		<portlet:param name="startDateMonth" value="<%= String.valueOf(startDateMonth) %>" />
		<portlet:param name="startDateYear" value="<%= String.valueOf(startDateYear) %>" />
		<portlet:param name="userId" value="<%= String.valueOf(userId) %>" />
		<portlet:param name="userName" value="<%= userName %>" />
	</liferay-portlet:renderURL>

	<liferay-ui:search-container
		displayTerms="<%= new DisplayTerms(renderRequest) %>"
		emptyResultsMessage="there-are-no-events"
		headerNames="user-id,user-name,resource-id,resource-name,resource-action,client-ip,create-date"
		iteratorURL="<%= iteratorURL %>"
	>
		<liferay-ui:search-form
			page="/event_search.jsp"
			servletContext="<%= application %>"
		/>

		<%
		int endDateDayHour = (endDateAmPm != Calendar.PM) ? endDateHour : endDateHour + 12;
		int startDateDayHour = (startDateAmPm != Calendar.PM) ? startDateHour : startDateHour + 12;

		Date endDate = PortalUtil.getDate(endDateMonth, endDateDay, endDateYear, endDateDayHour, endDateMinute, timeZone, null);
		Date startDate = PortalUtil.getDate(startDateMonth, startDateDay, startDateYear, startDateDayHour, startDateMinute, timeZone, null);

		DisplayTerms displayTerms = searchContainer.getDisplayTerms();

		if (displayTerms.isAdvancedSearch()) {
			total = AuditEventLocalServiceUtil.getAuditEventsCount(themeDisplay.getCompanyId(), userId, userName, startDate, endDate, eventType, className, classPK, clientHost, clientIP, serverName, serverPort, sessionID, displayTerms.isAndOperator());

			searchContainer.setTotal(total);

			searchContainer.setResults(AuditEventLocalServiceUtil.getAuditEvents(themeDisplay.getCompanyId(), userId, userName, startDate, endDate, eventType, className, classPK, clientHost, clientIP, serverName, serverPort, sessionID, displayTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd(), new AuditEventCreateDateComparator()));
		}
		else {
			String keywords = displayTerms.getKeywords();
			String number = Validator.isNumber(keywords) ? keywords : String.valueOf(0);

			total = AuditEventLocalServiceUtil.getAuditEventsCount(themeDisplay.getCompanyId(), new Long(number), keywords, null, null, keywords, keywords, keywords, keywords, keywords, keywords, new Integer(number), keywords, false);

			searchContainer.setResults(AuditEventLocalServiceUtil.getAuditEvents(themeDisplay.getCompanyId(), new Long(number), keywords, null, null, keywords, keywords, keywords, keywords, keywords, keywords, new Integer(number), keywords, false, searchContainer.getStart(), searchContainer.getEnd(), new AuditEventCreateDateComparator()));
		}
		%>

		<liferay-ui:search-container-row
			className="com.liferay.portal.audit.model.AuditEvent"
			keyProperty="auditEventId"
			modelVar="event"
		>
			<liferay-portlet:renderURL varImpl="rowURL">
				<portlet:param name="backURL" value="<%= currentURL %>" />
				<portlet:param name="mvcPath" value="/view_audit_event.jsp" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="auditEventId" value="<%= String.valueOf(event.getAuditEventId()) %>" />
			</liferay-portlet:renderURL>

			<%@ include file="/search_columns.jspf" %>
		</liferay-ui:search-container-row>

		<div class="separator"><!-- --></div>

		<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
	</liferay-ui:search-container>
</aui:form>