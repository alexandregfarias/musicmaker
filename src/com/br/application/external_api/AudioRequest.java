package com.br.application.external_api;

public class AudioRequest {

	private String prompt;
	private boolean makeInstrumental;
	private boolean waitAudio;

	public AudioRequest(String prompt, boolean makeInstrumental, boolean waitAudio) {
		this.prompt = prompt;
		this.makeInstrumental = makeInstrumental;
		this.waitAudio = waitAudio;
	}

	// Getters e Setters
	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public boolean isMakeInstrumental() {
		return makeInstrumental;
	}

	public void setMakeInstrumental(boolean makeInstrumental) {
		this.makeInstrumental = makeInstrumental;
	}

	public boolean isWaitAudio() {
		return waitAudio;
	}

	public void setWaitAudio(boolean waitAudio) {
		this.waitAudio = waitAudio;
	}

	@Override
	public String toString() {
		return "AudioRequest{" +
				"prompt='" + prompt + '\'' +
				", makeInstrumental=" + makeInstrumental +
				", waitAudio=" + waitAudio +
				'}';
	}


}
