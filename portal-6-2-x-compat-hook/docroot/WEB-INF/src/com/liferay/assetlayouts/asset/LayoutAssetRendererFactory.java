/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.assetlayouts.asset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.User;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;

/**
 * @author Eduardo Garcia
 */
public class LayoutAssetRendererFactory extends BaseAssetRendererFactory {

	public static final String TYPE = "layout";

	@Override
	public AssetEntry getAssetEntry(long assetEntryId)
		throws PortalException, SystemException {

		return getAssetEntry(getClassName(), assetEntryId);
	}

	@Override
	public AssetEntry getAssetEntry(String className, long classPK)
		throws PortalException, SystemException {

		Layout layout = LayoutLocalServiceUtil.getLayout(classPK);

		User user = UserLocalServiceUtil.getUserById(layout.getUserId());

		AssetEntry assetEntry = AssetEntryLocalServiceUtil.createAssetEntry(
			classPK);

		assetEntry.setGroupId(layout.getGroupId());
		assetEntry.setCompanyId(user.getCompanyId());
		assetEntry.setUserId(user.getUserId());
		assetEntry.setUserName(user.getFullName());
		assetEntry.setCreateDate(layout.getCreateDate());
		assetEntry.setClassNameId(
			PortalUtil.getClassNameId(Layout.class.getName()));
		assetEntry.setClassPK(layout.getLayoutId());
		assetEntry.setTitle(layout.getHTMLTitle(LocaleUtil.getSiteDefault()));

		return assetEntry;
	}

	@Override
	public AssetRenderer getAssetRenderer(long plid, int type)
		throws PortalException, SystemException {

		Layout layout = LayoutLocalServiceUtil.getLayout(plid);

		LayoutAssetRenderer layoutAssetRenderer = new LayoutAssetRenderer(
			layout);

		layoutAssetRenderer.setAssetRendererType(type);

		return layoutAssetRenderer;
	}

	@Override
	public String getClassName() {
		return Layout.class.getName();
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public boolean isSelectable() {
		return _SELECTABLE;
	}

	@Override
	protected String getIconPath(ThemeDisplay themeDisplay) {
		return themeDisplay.getPathThemeImages() + "/common/pages.png";
	}

	private static final boolean _SELECTABLE = false;

}