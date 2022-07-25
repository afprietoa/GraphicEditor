package view;


public interface ToolListener {

		public enum ToolEvent{
			LINE_CREATION,
			RECT_CREATION,
			ELLI_CREATION,
			CIRC_CREATION,
			TRI_CREATION,
			TXT_CREATION,
			SELECTION,
			ACTIVETOOL,
		}
		void toolChange(ToolEvent event);
	
}
