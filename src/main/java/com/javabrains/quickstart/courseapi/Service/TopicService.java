package com.javabrains.quickstart.courseapi.Service;

import com.javabrains.quickstart.courseapi.Entity.TopicEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<TopicEntity> topics = new ArrayList<>(Arrays.asList(
            new TopicEntity("s1", "spring", "spring course"),
            new TopicEntity("j1", "java", "java course"),
            new TopicEntity("r1", "react", "react course")
    ));


    public List<TopicEntity> getAllTopics() {
        return topics;
    }

    public TopicEntity getTopic(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

    }

    public void addTopic(TopicEntity topicEntity) {
        topics.add(topicEntity);
    }

    public void updateTopic(TopicEntity topicEntity, String id) {
        for (int i = 0; i < topics.size(); i++) {
            TopicEntity t = topics.get(i);
            if (t.getId().equals(id)) {
                topics.set(i, topicEntity);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }

}
