import axios from 'axios';

export default axios.create({
	baseURL: 'http://localhost:10101/api',
	'Content-Type': 'multipart/form-data',
});
