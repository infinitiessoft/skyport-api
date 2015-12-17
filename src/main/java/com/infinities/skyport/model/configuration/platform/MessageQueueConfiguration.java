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
package com.infinities.skyport.model.configuration.platform;

import java.io.Serializable;

import com.infinities.skyport.model.FunctionConfiguration;

public class MessageQueueConfiguration implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private FunctionConfiguration createMessageQueue = new FunctionConfiguration();
	private FunctionConfiguration getMessageQueue = new FunctionConfiguration();
	private FunctionConfiguration getProviderTermForMessageQueue = new FunctionConfiguration();
	private FunctionConfiguration listMessageQueues = new FunctionConfiguration();
	private FunctionConfiguration listMessageQueueStatus = new FunctionConfiguration();
	private FunctionConfiguration receiveMessage = new FunctionConfiguration();
	private FunctionConfiguration receiveMessages = new FunctionConfiguration();
	private FunctionConfiguration removeMessageQueue = new FunctionConfiguration();
	private FunctionConfiguration sendMessage = new FunctionConfiguration();


	public FunctionConfiguration getCreateMessageQueue() {
		return createMessageQueue;
	}

	public void setCreateMessageQueue(FunctionConfiguration createMessageQueue) {
		this.createMessageQueue = createMessageQueue;
	}

	public FunctionConfiguration getGetMessageQueue() {
		return getMessageQueue;
	}

	public void setGetMessageQueue(FunctionConfiguration getMessageQueue) {
		this.getMessageQueue = getMessageQueue;
	}

	public FunctionConfiguration getGetProviderTermForMessageQueue() {
		return getProviderTermForMessageQueue;
	}

	public void setGetProviderTermForMessageQueue(FunctionConfiguration getProviderTermForMessageQueue) {
		this.getProviderTermForMessageQueue = getProviderTermForMessageQueue;
	}

	public FunctionConfiguration getListMessageQueues() {
		return listMessageQueues;
	}

	public void setListMessageQueues(FunctionConfiguration listMessageQueues) {
		this.listMessageQueues = listMessageQueues;
	}

	public FunctionConfiguration getListMessageQueueStatus() {
		return listMessageQueueStatus;
	}

	public void setListMessageQueueStatus(FunctionConfiguration listMessageQueueStatus) {
		this.listMessageQueueStatus = listMessageQueueStatus;
	}

	public FunctionConfiguration getReceiveMessage() {
		return receiveMessage;
	}

	public void setReceiveMessage(FunctionConfiguration receiveMessage) {
		this.receiveMessage = receiveMessage;
	}

	public FunctionConfiguration getReceiveMessages() {
		return receiveMessages;
	}

	public void setReceiveMessages(FunctionConfiguration receiveMessages) {
		this.receiveMessages = receiveMessages;
	}

	public FunctionConfiguration getRemoveMessageQueue() {
		return removeMessageQueue;
	}

	public void setRemoveMessageQueue(FunctionConfiguration removeMessageQueue) {
		this.removeMessageQueue = removeMessageQueue;
	}

	public FunctionConfiguration getSendMessage() {
		return sendMessage;
	}

	public void setSendMessage(FunctionConfiguration sendMessage) {
		this.sendMessage = sendMessage;
	}

	@Override
	public MessageQueueConfiguration clone() {
		MessageQueueConfiguration clone = new MessageQueueConfiguration();
		clone.createMessageQueue = createMessageQueue.clone();
		clone.getMessageQueue = getMessageQueue.clone();
		clone.getProviderTermForMessageQueue = getProviderTermForMessageQueue.clone();
		clone.listMessageQueues = listMessageQueues.clone();
		clone.listMessageQueueStatus = listMessageQueueStatus.clone();
		clone.receiveMessage = receiveMessage.clone();
		clone.receiveMessages = receiveMessages.clone();
		clone.removeMessageQueue = removeMessageQueue.clone();
		clone.sendMessage = sendMessage.clone();
		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createMessageQueue == null) ? 0 : createMessageQueue.hashCode());
		result = prime * result + ((getMessageQueue == null) ? 0 : getMessageQueue.hashCode());
		result = prime * result + ((getProviderTermForMessageQueue == null) ? 0 : getProviderTermForMessageQueue.hashCode());
		result = prime * result + ((listMessageQueueStatus == null) ? 0 : listMessageQueueStatus.hashCode());
		result = prime * result + ((listMessageQueues == null) ? 0 : listMessageQueues.hashCode());
		result = prime * result + ((receiveMessage == null) ? 0 : receiveMessage.hashCode());
		result = prime * result + ((receiveMessages == null) ? 0 : receiveMessages.hashCode());
		result = prime * result + ((removeMessageQueue == null) ? 0 : removeMessageQueue.hashCode());
		result = prime * result + ((sendMessage == null) ? 0 : sendMessage.hashCode());
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
		MessageQueueConfiguration other = (MessageQueueConfiguration) obj;
		if (createMessageQueue == null) {
			if (other.createMessageQueue != null)
				return false;
		} else if (!createMessageQueue.equals(other.createMessageQueue))
			return false;
		if (getMessageQueue == null) {
			if (other.getMessageQueue != null)
				return false;
		} else if (!getMessageQueue.equals(other.getMessageQueue))
			return false;
		if (getProviderTermForMessageQueue == null) {
			if (other.getProviderTermForMessageQueue != null)
				return false;
		} else if (!getProviderTermForMessageQueue.equals(other.getProviderTermForMessageQueue))
			return false;
		if (listMessageQueueStatus == null) {
			if (other.listMessageQueueStatus != null)
				return false;
		} else if (!listMessageQueueStatus.equals(other.listMessageQueueStatus))
			return false;
		if (listMessageQueues == null) {
			if (other.listMessageQueues != null)
				return false;
		} else if (!listMessageQueues.equals(other.listMessageQueues))
			return false;
		if (receiveMessage == null) {
			if (other.receiveMessage != null)
				return false;
		} else if (!receiveMessage.equals(other.receiveMessage))
			return false;
		if (receiveMessages == null) {
			if (other.receiveMessages != null)
				return false;
		} else if (!receiveMessages.equals(other.receiveMessages))
			return false;
		if (removeMessageQueue == null) {
			if (other.removeMessageQueue != null)
				return false;
		} else if (!removeMessageQueue.equals(other.removeMessageQueue))
			return false;
		if (sendMessage == null) {
			if (other.sendMessage != null)
				return false;
		} else if (!sendMessage.equals(other.sendMessage))
			return false;
		return true;
	}

}
