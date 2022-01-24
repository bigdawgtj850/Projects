import React, { Component } from "react"

class Weather extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            location: this.props.location,
            place: "",
            temp: "",
            weather: "",
            icon: "",
            showDiv: false
        };
    }

    render() {
        window.addEventListener('unhandledrejection', function (event) {
            // the event object has two special properties:
            // alert(event.promise); // [object Promise] - the promise that generated the error
            alert(event.reason); // Error: Whoops! - the unhandled error object

        });
        const { showDiv } = this.state
        return (
            <div className="weather">
                <div className="button">
                    <button onClick={() => { this.setState({ showDiv: !showDiv }); this.getWeather(); }}>
                        {showDiv ? 'Hide Weather' : 'Show Weather'}
                    </button>
                    {showDiv && (
                        <div className="showWeather">
                            <h1 >Location: {this.state.place}</h1>
                            <h3 >Temperature: {this.state.temp} °F</h3>
                            <h3 >Condition: {this.state.weather}</h3>
                            <img className="weatherIcon" src={`http://openweathermap.org/img/w/${this.state.icon}.png`} alt="wthr img" />
                        </div>
                    )}
                </div>

                <div>

                </div>
            </div>
        );
    }

    changeValue = (event) => {

        this.setState({
            location: event.target.value
        });
    }



    getWeather = () => {

        fetch('https://api.openweathermap.org/data/2.5/weather?q=' + this.state.location + '&units=metric&appid=81a43d491be65ebc3ef085d6d6e6365b')
            .then(response => response.json())
            .then(data => {
                this.setState({
                    place: data.name,
                    temp: ((data.main.temp * 1.8) + 32).toFixed(0),
                    weather: data.weather[0].main,
                    icon: data.weather[0].icon
                })
            }).catch(error => {
                // Maybe present some error/failure UI to the user here
                this.setState({
                    place: "error from open map api",
                    temp: "error from open map api",
                    weather: "error from open map api",
                })
            });

    }
}

export default Weather