import { React, Component } from "react"
import { NavLink } from 'react-router-dom'
import "../styles/navigation_bar.css"
import Button from "./inputs/Button";
import DropDownItem from "./inputs/DropDownItem";
import DropdownButton from 'react-bootstrap/DropdownButton'
import Dropdown from 'react-bootstrap/Dropdown'
import NavDropdown from 'react-bootstrap/NavDropdown'

const BackEnd_URL = "http://localhost:8080/api/eventBoard/"


class NavBar extends Component {

    handleSelect = (evtKey, evt) => {
        console.log(evt)
    }

    render() {
        return (
            <div className="nav_list">
                <ul>
                    {/* <li><NavLink to='/'>Home</NavLink></li> */}
                    <li><NavLink to='/posts'>All Posts</NavLink></li>
                    <li><NavLink to='/create'>Create</NavLink></li>
    
                                      
                </ul>
            </div>
        );
    }
}
 
export default NavBar