package model;

import model.DocumentListener.DocumentEvent;

public interface DocumentListener {
	public enum DocumentEvent{
		NEW,
		SAVED,
		LOADED,
		ADD_FIGURE,
		REM_FIGURE,
		SEL_FIGURES,
		DESELECTED,
	}
	void documentChange(DocumentEvent d);
}
