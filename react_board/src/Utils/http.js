import axios from 'axios'

export default axios.create({
    baseURI: "http://localhost:8080",
    header: {
        "Content-Type": "application/json"
    }
});