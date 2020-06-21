<template>
	<v-dialog
		v-model="setDialog.isShow"
		:width="setDialog.width"
		:height="setDialog.height"
		@click:outside="$emit('closeviewer')"
		:overlay-color="setDialog.overlay_color"
		:overlay-opacity="setDialog.overlay_opacity"
	>
		<h1>미리보기</h1>
		<v-card>
			<viewer :initialValue="value" v-if="value != null" />
		</v-card>
	</v-dialog>
</template>

<script>
import { Viewer } from '@toast-ui/vue-editor';
import '@toast-ui/editor/dist/toastui-editor.css';
import '@toast-ui/editor/dist/toastui-editor-viewer.css';
import 'codemirror/lib/codemirror.css';

export default {
	props: {
		setDialog: Object,
		value: String,
	},
	components: {
		viewer: Viewer,
	},
};
</script>
