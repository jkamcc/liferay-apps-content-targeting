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

package com.liferay.portal.audit.hook.listeners.util;

import com.liferay.portal.kernel.bean.BeanPropertiesUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class AttributesBuilder {

	public AttributesBuilder(Object newBean, Object oldBean) {
		_newBean = newBean;
		_oldBean = oldBean;
	}

	public void add(String name) {
		String newValue = String.valueOf(
			BeanPropertiesUtil.getObject(_newBean, name));
		String oldValue = String.valueOf(
			BeanPropertiesUtil.getObject(_oldBean, name));

		if (!Validator.equals(newValue, oldValue)) {
			Attribute attribute = new Attribute(name, newValue, oldValue);

			_attributes.add(attribute);
		}
	}

	public List<Attribute> getAttributes() {
		return _attributes;
	}

	private List<Attribute> _attributes = new ArrayList<Attribute>();
	private Object _newBean;
	private Object _oldBean;

}