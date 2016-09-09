// DELETE ME
// tutorial1.js
var CommentBox = React.createClass({
  render: function() {
    return (
      <div className="commentBox">
        <h1>Comments</h1>
<CommentList />
      </div>
    );
  }
});
ReactDOM.render(
  <CommentBox />,
  document.getElementById('leftContent')
);
