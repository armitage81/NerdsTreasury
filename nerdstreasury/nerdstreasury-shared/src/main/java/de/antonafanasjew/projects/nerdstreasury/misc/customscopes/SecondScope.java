package de.antonafanasjew.projects.nerdstreasury.misc.customscopes;

import java.util.Map;

import org.springframework.beans.factory.ObjectFactory;

import com.google.common.collect.Maps;

public class SecondScope implements org.springframework.beans.factory.config.Scope {

	private Map<Long, Map<String, Object>> cache = Maps.newConcurrentMap();


	@Override
	public synchronized Object get(String name, ObjectFactory<?> objectFactory) {
		long currentMinute = currentSecond();
		Map<String, Object> scope = this.cache.get(currentMinute);
		if (scope == null) {
			scope = Maps.newConcurrentMap();
			this.cache.put(currentMinute, scope);
		}
		Object object = scope.get(name);
		if (object == null) {
			object = objectFactory.getObject();
			scope.put(name, object);
		}
		return object;
	}

	@Override
	public synchronized Object remove(String name) {
		long currentMinute = currentSecond();
		Map<String, Object> scope = this.cache.get(currentMinute);
		if (scope != null) {
			return scope.remove(name);
		} else {
			return null;
		}
	}

	@Override
	public synchronized void registerDestructionCallback(String name, Runnable callback) {

	}

	@Override
	public synchronized Object resolveContextualObject(String key) {
		return null;
	}

	@Override
	public synchronized String getConversationId() {
		return String.valueOf(currentSecond());
	}
	
	private long currentSecond() {
		return System.currentTimeMillis() / 1000;
	}

}
