/*******************************************************************************
 * Copyright 2015 InfinitiesSoft Solutions Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package com.infinities.skyport.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.google.common.collect.ForwardingMap;

public class ParForwardingMap extends ForwardingMap<String, String> {

	private final Map<String, String[]> srcMap;


	public ParForwardingMap(final Map<String, String[]> reqMap) {
		srcMap = new HashMap<String, String[]>();
		srcMap.putAll(reqMap);
	} // ImmutableMap.Builder<String, String[]>().putAll(reqMap).build(); }

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Map delegate() {
		return srcMap;
	}

	@Override
	public String get(final Object key) {
		Object vals = null;

		for (final Object mkey : delegate().keySet()) {
			if (mkey.equals(key)) {
				vals = delegate().get(mkey);
				break;
			}
		}
		if (vals != null && vals instanceof String[]) {
			return (vals == null || ((String[]) vals).length == 0) ? null : (String) (((String[]) vals)[0]);
		} else {
			return vals == null ? null : ((String) vals);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Iterator<String> iter = srcMap.keySet().iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			sb.append(key);
			sb.append('=');
//			sb.append('"');
			sb.append(get(key));
//			sb.append('"');
			if (iter.hasNext()) {
				sb.append(',').append(' ');
			}
		}
		return sb.toString();

	}
}
