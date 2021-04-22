import axios from 'axios';

export default axios.create({
	baseURL: 'http://api:10001/api',
	headers: { 'Content-Type': 'application/json' },
});
