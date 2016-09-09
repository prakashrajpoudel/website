/**
 * Created by root on 8/29/16.
 */


class Home extends React.Component{
    render() {
        return <span className="welcometext">स्वागत छ ।</span>
    }
}
//const Home = () => <h1>Hello from Home!</h1>
const Address = () => <h1> We are here </h1>
const ReactRouter = window.ReactRouter;

ReactDOM.render((
    <ReactRouter.Router>
    <ReactRouter.Route path="/reactHome" component={Home} />
    <ReactRouter.Route path="/reactLogin" component={Address} />
    </ReactRouter.Router>
), document.getElementById('main'));

class Menu extends React.Component{
    render() {
        return (<div><ul className="topnav" id="myTopnav">
            <li><a className="active" href="#/reactHome">Home</a></li>
            <li><a href="#/reactLogin">Login</a></li>
            <li><a href="#/addResidence">AddResidence</a></li>
            <li><a href="#/receivedList">Received List</a></li>
        </ul>
            <addResidence></addResidence>
        </div>);
    }
}
/* Testing part */
class LikeButton extends React.Component {
    constructor() {
        super();
        this.state = {
            liked: false
        };
        this.handleClick = this.handleClick.bind(this);
    }
    handleClick() {
        this.setState({liked: !this.state.liked});
    }
    render() {
        const text = this.state.liked ? 'liked' : 'haven\'t liked';
        return (
            <div onClick={this.handleClick}>
                You {text} this. Click to toggle.
            </div>
        );
    }
}
ReactDOM.render(<Menu />, document.getElementById('menu'));
ReactDOM.render(<LikeButton />, document.getElementById('liked'));