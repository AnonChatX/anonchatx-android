package org.anonchatx.android.privategroup.creation;

import org.anonchatx.android.fragment.BaseFragment.BaseFragmentListener;

interface CreateGroupListener extends BaseFragmentListener {

	void onGroupNameChosen(String name);
}
