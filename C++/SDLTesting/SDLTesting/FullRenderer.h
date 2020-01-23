#pragma once
#include <SDL.h>
#include <string>
class FullRenderer {

private:
	SDL_Window* myWindow;
	SDL_Renderer* myRenderer;
	char* winName;
	int winWidth;
	int winHeight;
	SDL_WindowFlags winFlag;
	SDL_RendererFlags renderFlag;

	struct colors {
		int r;
		int g;
		int b;
		int a;
	} colors;

public:
	FullRenderer(char* name, int w, int h, SDL_WindowFlags wF, SDL_RendererFlags rF, int r, int g, int b, int a);

	SDL_Window* getWindow() { return myWindow; }
	SDL_Renderer* getRenderer() { return myRenderer; }
	void showWindow();
	void setBackgroundColor(int r, int g, int b, int a) { colors = { r, g, b, a }; }
};