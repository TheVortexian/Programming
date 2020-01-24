#pragma once
#include <SDL.h>
#include <stdio.h>
#include <SDL_image.h>

class FullRenderer {

private:
	// renderer and window information
	SDL_Window* myWindow;
	SDL_Renderer* myRenderer;
	char* winName;
	int winWidth;
	int winHeight;
	SDL_WindowFlags winFlag;
	SDL_RendererFlags renderFlag;
	SDL_Texture* image;
	SDL_Rect imageRect;

	bool exit = false; // when to exit the application
	double imgX; // true location of the image
	double imgY;

	// window background color (not really necessary)
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
	void showWindow(); // shows the window
	void setBackgroundColor(int r, int g, int b, int a) { colors = { r, g, b, a }; }
	void loadImage(char* imgName, int x, int y, double scale = 1.0); // loads an image
	void update(double speed); // update application (mostly for keypresses)
};