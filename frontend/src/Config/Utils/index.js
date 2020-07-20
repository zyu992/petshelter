import axios from 'axios';
import { createFromIconfontCN } from '@ant-design/icons';

export var Axios = axios.create({});

export const IconFont = createFromIconfontCN({
    scriptUrl: '//at.alicdn.com/t/font_1954731_o53yvryws4.js'
})