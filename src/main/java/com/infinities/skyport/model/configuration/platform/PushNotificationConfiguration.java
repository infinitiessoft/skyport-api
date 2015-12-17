package com.infinities.skyport.model.configuration.platform;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class PushNotificationConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration confirmSubscription = new FunctionConfiguration();
	private FunctionConfiguration createTopic = new FunctionConfiguration();
	private FunctionConfiguration getTopic = new FunctionConfiguration();
	private FunctionConfiguration listSubscriptions = new FunctionConfiguration();
	private FunctionConfiguration listTopicStatus = new FunctionConfiguration();
	private FunctionConfiguration listTopics = new FunctionConfiguration();
	private FunctionConfiguration publish = new FunctionConfiguration();
	private FunctionConfiguration removeTopic = new FunctionConfiguration();
	private FunctionConfiguration subscribe = new FunctionConfiguration();
	private FunctionConfiguration unsubscribe = new FunctionConfiguration();


	public FunctionConfiguration getConfirmSubscription() {
		return confirmSubscription;
	}

	public void setConfirmSubscription(FunctionConfiguration confirmSubscription) {
		this.confirmSubscription = confirmSubscription;
	}

	public FunctionConfiguration getCreateTopic() {
		return createTopic;
	}

	public void setCreateTopic(FunctionConfiguration createTopic) {
		this.createTopic = createTopic;
	}

	public FunctionConfiguration getGetTopic() {
		return getTopic;
	}

	public void setGetTopic(FunctionConfiguration getTopic) {
		this.getTopic = getTopic;
	}

	public FunctionConfiguration getListSubscriptions() {
		return listSubscriptions;
	}

	public void setListSubscriptions(FunctionConfiguration listSubscriptions) {
		this.listSubscriptions = listSubscriptions;
	}

	public FunctionConfiguration getListTopicStatus() {
		return listTopicStatus;
	}

	public void setListTopicStatus(FunctionConfiguration listTopicStatus) {
		this.listTopicStatus = listTopicStatus;
	}

	public FunctionConfiguration getListTopics() {
		return listTopics;
	}

	public void setListTopics(FunctionConfiguration listTopics) {
		this.listTopics = listTopics;
	}

	public FunctionConfiguration getPublish() {
		return publish;
	}

	public void setPublish(FunctionConfiguration publish) {
		this.publish = publish;
	}

	public FunctionConfiguration getRemoveTopic() {
		return removeTopic;
	}

	public void setRemoveTopic(FunctionConfiguration removeTopic) {
		this.removeTopic = removeTopic;
	}

	public FunctionConfiguration getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(FunctionConfiguration subscribe) {
		this.subscribe = subscribe;
	}

	public FunctionConfiguration getUnsubscribe() {
		return unsubscribe;
	}

	public void setUnsubscribe(FunctionConfiguration unsubscribe) {
		this.unsubscribe = unsubscribe;
	}

	@Override
	public PushNotificationConfiguration clone() {
		PushNotificationConfiguration clone = new PushNotificationConfiguration();
		clone.confirmSubscription = confirmSubscription.clone();
		clone.createTopic = createTopic.clone();
		clone.getTopic = getTopic.clone();
		clone.listSubscriptions = listSubscriptions.clone();
		clone.listTopicStatus = listTopicStatus.clone();
		clone.listTopics = listTopics.clone();
		clone.publish = publish.clone();
		clone.removeTopic = removeTopic.clone();
		clone.subscribe = subscribe.clone();
		clone.unsubscribe = unsubscribe.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((confirmSubscription == null) ? 0 : confirmSubscription.hashCode());
		result = prime * result + ((createTopic == null) ? 0 : createTopic.hashCode());
		result = prime * result + ((getTopic == null) ? 0 : getTopic.hashCode());
		result = prime * result + ((listSubscriptions == null) ? 0 : listSubscriptions.hashCode());
		result = prime * result + ((listTopicStatus == null) ? 0 : listTopicStatus.hashCode());
		result = prime * result + ((listTopics == null) ? 0 : listTopics.hashCode());
		result = prime * result + ((publish == null) ? 0 : publish.hashCode());
		result = prime * result + ((removeTopic == null) ? 0 : removeTopic.hashCode());
		result = prime * result + ((subscribe == null) ? 0 : subscribe.hashCode());
		result = prime * result + ((unsubscribe == null) ? 0 : unsubscribe.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PushNotificationConfiguration other = (PushNotificationConfiguration) obj;
		if (confirmSubscription == null) {
			if (other.confirmSubscription != null)
				return false;
		} else if (!confirmSubscription.equals(other.confirmSubscription))
			return false;
		if (createTopic == null) {
			if (other.createTopic != null)
				return false;
		} else if (!createTopic.equals(other.createTopic))
			return false;
		if (getTopic == null) {
			if (other.getTopic != null)
				return false;
		} else if (!getTopic.equals(other.getTopic))
			return false;
		if (listSubscriptions == null) {
			if (other.listSubscriptions != null)
				return false;
		} else if (!listSubscriptions.equals(other.listSubscriptions))
			return false;
		if (listTopicStatus == null) {
			if (other.listTopicStatus != null)
				return false;
		} else if (!listTopicStatus.equals(other.listTopicStatus))
			return false;
		if (listTopics == null) {
			if (other.listTopics != null)
				return false;
		} else if (!listTopics.equals(other.listTopics))
			return false;
		if (publish == null) {
			if (other.publish != null)
				return false;
		} else if (!publish.equals(other.publish))
			return false;
		if (removeTopic == null) {
			if (other.removeTopic != null)
				return false;
		} else if (!removeTopic.equals(other.removeTopic))
			return false;
		if (subscribe == null) {
			if (other.subscribe != null)
				return false;
		} else if (!subscribe.equals(other.subscribe))
			return false;
		if (unsubscribe == null) {
			if (other.unsubscribe != null)
				return false;
		} else if (!unsubscribe.equals(other.unsubscribe))
			return false;
		return true;
	}

}
