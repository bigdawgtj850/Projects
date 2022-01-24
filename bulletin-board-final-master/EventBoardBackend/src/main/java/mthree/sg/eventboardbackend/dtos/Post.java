/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mthree.sg.eventboardbackend.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author stephenespinal
 */
public class Post {

    private int postId;
    private String title;
    private String category;
    private String addressString;
    private String zipCode;
    private String preview;
    private String eventInfo;
    private String dateOfEvent;

    private User user;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAddressString() {
        return addressString;
    }

    public void setAddressString(String addressString) {
        this.addressString = addressString;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }

    public String getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(String dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.postId;
        hash = 53 * hash + Objects.hashCode(this.title);
        hash = 53 * hash + Objects.hashCode(this.category);
        hash = 53 * hash + Objects.hashCode(this.addressString);
        hash = 53 * hash + Objects.hashCode(this.zipCode);
        hash = 53 * hash + Objects.hashCode(this.preview);
        hash = 53 * hash + Objects.hashCode(this.eventInfo);
        hash = 53 * hash + Objects.hashCode(this.dateOfEvent);
        hash = 53 * hash + Objects.hashCode(this.user);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Post other = (Post) obj;
        if (this.postId != other.postId) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.category, other.category)) {
            return false;
        }
        if (!Objects.equals(this.addressString, other.addressString)) {
            return false;
        }
        if (!Objects.equals(this.zipCode, other.zipCode)) {
            return false;
        }
        if (!Objects.equals(this.preview, other.preview)) {
            return false;
        }
        if (!Objects.equals(this.eventInfo, other.eventInfo)) {
            return false;
        }
        if (!Objects.equals(this.dateOfEvent, other.dateOfEvent)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }



}
