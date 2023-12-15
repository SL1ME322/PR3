package com.example.pr2up.dao;

import com.example.pr2up.models.PublisherModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PublisherDao {
    private List<PublisherModel> publishers = new ArrayList<>();
    private static int PUBLISHERS_COUNT;

    public PublisherDao() {
        publishers.add(new PublisherModel(++PUBLISHERS_COUNT, "Publisher1", "Address1", "123-456-7890", "www.publisher1.com"));
        publishers.add(new PublisherModel(++PUBLISHERS_COUNT, "Publisher2", "Address2", "987-654-3210", "www.publisher2.com"));
    }

    public PublisherModel get(int id) {

        return publishers.stream().filter(publisher -> publisher.getPublisherId() == id).findFirst().orElse(null);
    }

    public List<PublisherModel> getAll() {
        return publishers;
    }

    public void save(PublisherModel publisherModel) {
        publisherModel.setPublisherId(++PUBLISHERS_COUNT);
        publishers.add(publisherModel);
    }

    public void update(int id, PublisherModel updatedPublisher) {
        PublisherModel existingPublisher = get(id);

        if (existingPublisher != null) {
            existingPublisher.setName(updatedPublisher.getName());
            existingPublisher.setAddress(updatedPublisher.getAddress());
            existingPublisher.setPhoneNumber(updatedPublisher.getPhoneNumber());
            existingPublisher.setWebsite(updatedPublisher.getWebsite());
        }
    }

    public void delete(int id) {
        publishers.removeIf(publisher -> publisher.getPublisherId() == id);
    }
}
