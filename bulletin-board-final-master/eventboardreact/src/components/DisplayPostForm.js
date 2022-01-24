import React, {Component} from 'react';

import TextArea from "./inputs/TextArea";
import Input from "./inputs/Input";
import DropDownItem from "./inputs/DropDownItem";
import Button from "./inputs/Button";

class DisplayPostForm extends Component {
    state = {
        submission: {
            category: "",
            title: "",
            name: "",
            date: "",
            address: "",
            zipCode: "",
            preview: "",
            eventInfo: "",
            weatherIcon: "",
            weatherInfo: ""
        }, 
        allCategories: ["Outdoor", "Gaming", "Educational", "Celebration", "Other"]
    };

    constructor(props) {
        super(props);
        this.handleEditPost = this.handleEditPost.bind(this);
        this.handleAddComment = this.handleAddComment.bind(this);
        this.handleDeletePost = this.handleDeletePost.bind(this);
        this.handleWeather = this.handleWeather.bind(this);
        this.DisplayComments = this.DisplayComments.bind(this);
    }

    handleEditPost(event) {

    }

    handleAddComment(event) {

    }

    handleDeletePost(event) {

    }

    handleWeather(event) {

    }

    DisplayComments(event) {

    }

    render() {
        let {submission, allCategories} = this.state;

        return (
            <form>

            </form>
        )
    }

}

export default DisplayPostForm;