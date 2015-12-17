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
