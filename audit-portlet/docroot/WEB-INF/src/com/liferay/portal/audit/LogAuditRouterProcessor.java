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

import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.audit.AuditMessageProcessor;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Mika Koivisto
 * @author Brian Wing Shun Chan
 */
public class LogAuditRouterProcessor implements AuditMessageProcessor {


	public void process(AuditMessage auditMessage) {
		try {
			doProcess(auditMessage);
		}
		catch (Exception e) {
			_log.fatal("Unable to process audit message " + auditMessage, e);
		}
	}

	public void setLogMessageFormatter(
		LogMessageFormatter logMessageFormatter) {

		_logMessageFormatter = logMessageFormatter;
	}

	public void setOutputToConsole(boolean outputToConsole) {
		_outputToConsole = outputToConsole;
	}

	protected void doProcess(AuditMessage auditMessage) throws Exception {
		if (_log.isInfoEnabled() || _outputToConsole) {
			String logMessage = _logMessageFormatter.format(auditMessage);

			if (_log.isInfoEnabled()) {
				_log.info(logMessage);
			}

			if (_outputToConsole) {
				System.out.println("LogAuditRouterProcessor: " + logMessage);
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		LogAuditRouterProcessor.class);

	private LogMessageFormatter _logMessageFormatter;
	private boolean _outputToConsole;

}