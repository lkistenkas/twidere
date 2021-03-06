/*
 *				Twidere - Twitter client for Android
 * 
 * Copyright (C) 2012 Mariotaku Lee <mariotaku.lee@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.mariotaku.twidere.fragment;

import java.util.List;

import org.mariotaku.twidere.adapter.ParcelableStatusesAdapter;
import org.mariotaku.twidere.loader.ListTimelineLoader;
import org.mariotaku.twidere.model.ParcelableStatus;

import android.os.Bundle;
import android.support.v4.content.Loader;

public class UserListTimelineFragment extends ParcelableStatusesListFragment {

	@Override
	public boolean isListLoadFinished() {
		return false;
	}

	@Override
	public Loader<List<ParcelableStatus>> newLoaderInstance(Bundle args) {
		int list_id = -1;
		long account_id = -1, max_id = -1, user_id = -1;
		String screen_name = null, list_name = null;
		if (args != null) {
			list_id = args.getInt(INTENT_KEY_LIST_ID, -1);
			account_id = args.getLong(INTENT_KEY_ACCOUNT_ID, -1);
			max_id = args.getLong(INTENT_KEY_MAX_ID, -1);
			user_id = args.getLong(INTENT_KEY_USER_ID, -1);
			screen_name = args.getString(INTENT_KEY_SCREEN_NAME);
			list_name = args.getString(INTENT_KEY_LIST_NAME);
		}
		return new ListTimelineLoader(getActivity(), account_id, list_id, user_id, screen_name, list_name, max_id,
				getData());
	}

	@Override
	public void onDataLoaded(Loader<List<ParcelableStatus>> loader, ParcelableStatusesAdapter adapter) {

	}

}
