package com.hemant.courseapi.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PreviousTopicService {

	private List<Topic> topics = new ArrayList<>(
			Arrays.asList(new Topic("spring", "Spring Framework", "Spring Framework Description"),
					new Topic("java", "JAVA Lang.", "JAVA Lang. Description"),
					new Topic("javascript", "JavaScript", "JavaScript Description")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {

		if (topic != null) {
			topics.add(topic);
		}
	}

	public void updateTopic(String topicId, Topic topic) {
		if (topicId != null && topic != null) {
			for (int i = 0; i < topics.size(); i++) {
				Topic t = topics.get(i);
				if (t.getId().equals(topic.getId())) {
					topics.set(i, topic);
					return;
				}
			}
		}
	}

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getId().equals(id));
	}
}
