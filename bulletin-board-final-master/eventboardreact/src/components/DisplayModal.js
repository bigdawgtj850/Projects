import {React, Component} from 'react'
import { Form, Button, Modal } from 'react-bootstrap'

const BACKEND_URL = "http://localhost:8080/api/eventBoard/"

class DisplayModal extends Component {

    state = {
        showPostModal: false,
        postsData: {
            category: "",
            name: "",
            title: "",
            date: "",
            address: "",
            zipCode: "",
            preview: "",
            eventInfo: ""
        }, 
        allCategories: ["Outdoor", "Gaming", "Educational", "Celebration", "Other"],
        editPostData: {
            category: "",
            name: "",
            title: "",
            date: "",
            address: "",
            zipCode: "",
            preview: "",
            eventInfo: ""
        },
        allCategories: ["Outdoor", "Gaming", "Educational", "Celebration", "Other"]
    };

    constructor(props) {
        super(props);
        this.handleSubmissionChange = this.handleSubmissionChange.bind(this);
        this.handleClear = this.handleClear.bind(this);
    }

    handleEditModalClose = (event) => {
        console.log("Closing Post Edit Modal")
        this.setState({ showPostModal: false})
    }

    handleEditModalOpen = (event) => {
        console.log("Opening Post Edit Modal")
        if (event) event.preventDefault();
      
        let postId = event.target.value;
        console.log(`Editing Post id ${postId}`)
      
        
        fetch(BACKEND_URL + '/post/getPost'+ postId)
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            this.setState(
              { editPostData : data , showPostModal : true}
            )
        })
        .catch((error) => {
            console.error('Error:', error);
        });
      }
      
      handleEditFormChange = (event) => {
      
        let inputName = event.target.name;
        let inputValue = event.target.value;
        let PostInfo = this.state.editPostData;
      
        console.log(`Something changed in ${inputName} : ${inputValue}`)
      
        if(PostInfo.hasOwnProperty(inputName)){
            PostInfo[inputName] = inputValue;
            this.setState({ editPostData : PostInfo })
        }
      }
      
      handleEditFormSubmit = (event) => {
        if (event) event.preventDefault();
        let postId = event.target.value;
        console.log(`Submitting edit for post id ${postId}`)
        console.log(this.state.editPostData)
      
        fetch(BACKEND_URL + '/post/updatePost/' + postId, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            }, 
            body: JSON.stringify(this.state.editContactData),
        }, {mode: 'cors'})
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            this.setState({ showPostModal : false })
            this.loadPosts();
        })
        .catch((error) => {
            console.error('Error:', error);
        });
      
      }

      loadPosts() {
        this.setState({loading: true})
        console.log("Loading Posts...")
        fetch (BACKEND_URL + "/post/posts", {mode: 'cors'})
            .then(response => {
                return response.json()
            })
            .then(response => this.setState(
                {postsData: response, loading: false}
            ))
    }

      render() {
        return (
            <DisplayModal
                show={this.showPostModal}
                handleSubmit={this.handleEditFormSubmit}
                handleChange={this.handleEditFormChange}
                handleClose={this.handleEditModalClose}
                postData={this.state.editPostData} />
        )

      }
}

export default DisplayModal

