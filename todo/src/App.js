import Form from "./components/Form";
import List from "./components/List";

function App() {
  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-sm-6">
          <Form />
          <List />
        </div>
      </div>
    </div>
  );
}

export default App;