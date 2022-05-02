import axios from 'axios'

// create an axios instance
const request = axios.create({
    baseURL: 'https://wormflesh.top:8881/api',
    timeout: 5000 // request timeout
})

export default request