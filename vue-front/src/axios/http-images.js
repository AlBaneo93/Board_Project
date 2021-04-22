import axios from 'axios';

export default axios.create({
	baseURL: 'http://image:10101/api',
	'Content-Type': 'multipart/form-data',
});
