import React, { Component } from "react";
import {Container, Row, Col} from 'react-bootstrap'
import { Switch } from "react-router-dom/cjs/react-router-dom.min";
import { Route } from "react-router-dom"
import './App.css'
import NavBar from "./components/navigation_bar"
import HomePage from './pages/home_page'
import PostsPage from './pages/posts_page'
import CreatePage from './pages/create_page'
import ViewPostPage from './pages/view_page'
import EditPostPage from './pages/edit_page'


import EventDisplayForm from "./components/CreateEventForm";

const BACKEND_URL = "http://localhost:8080/api/eventBoard/"

class App extends Component {

  handleEditModalOpen = (event) => {
    console.log("Opening Updated Modal")
    if (event) event.preventDefault();
  
    let contactId = event.target.value;
    console.log(`Editing Contact id ${contactId}`)
  
    // submitting a GET request to the /contact/{contactId} endpoint
    fetch(BACKEND_URL+'/contact/'+contactId)
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        this.setState(
          { editcontactData : data , showcontactModal : true}
        )
    })
    .catch((error) => {
        console.error('Error:', error);
    });
  }
  
  handleEditFormChange = (event) => {
  
    let inputName = event.target.name;
    let inputValue = event.target.value;
    let contactInfo = this.state.editcontactData;
  
    console.log(`Something changed in ${inputName} : ${inputValue}`)
  
    if(contactInfo.hasOwnProperty(inputName)){
        contactInfo[inputName] = inputValue;
        this.setState({ editcontactData : contactInfo })
    }
  
  }
  
  handleEditFormSubmit = (event) => {
    if (event) event.preventDefault();
    let contactId = event.target.value;
    console.log(`Submitting edit for contact id ${contactId}`)
    console.log(this.state.editContactData)
  
    fetch(BACKEND_URL+'/contact/'+contactId, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.state.editContactData),
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        this.setState({ showEditModal : false })
        this.loadContactData();
    })
    .catch((error) => {
        console.error('Error:', error);
    });
  
  }
  
  render() {
    return (
      <div className="container App">
        <h1 className="text-center App-heading-text">Event Board</h1>
        <NavBar />
        <main>
          <Switch>
            <Route exact path='/' component={HomePage} />
            <Route path='/home' component={HomePage} />
            <Route path='/posts' component={PostsPage} />
            <Route path='/create' component={CreatePage} />
            <Route path='/view' component={ViewPostPage} />
            <Route path='/edit' component={EditPostPage} />
          </Switch>

          
        </main>
        
        <br />
      </div>
    );
  }
}
 
export default App;