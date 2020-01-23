#include "FullRenderer.h";
#include <stdio.h>
FullRenderer::FullRenderer(char* name, int w, int h, SDL_WindowFlags wF, SDL_RendererFlags rF, int r, int g, int b, int a) {
	if (SDL_Init(SDL_INIT_EVERYTHING) < 0) {
		printf("Error initializing SDL.\n");
		return;
	}
	// create window and renderer with SDL
	FullRenderer::myWindow = SDL_CreateWindow(name, SDL_WINDOWPOS_CENTERED, SDL_WINDOWPOS_CENTERED, w, h, wF);
	FullRenderer::myRenderer = SDL_CreateRenderer(FullRenderer::getWindow(), -1, rF);
	// check if either window or renderer weren't correctly init'd
	if (FullRenderer::getWindow() == NULL) { printf("Error creating window. "); }
	if (FullRenderer::getRenderer() == NULL) { printf("Error creating renderer. "); }
	FullRenderer::setBackgroundColor(r, g, b, a); // set background color of the window
}

void FullRenderer::showWindow() {
	/*
		Set window background color, using colors from the struct in FullRenderer
		then, clear our renderer
		then, render everything in the backbuffer SDL uses (which we draw to before renderPresent).
	*/
	SDL_SetRenderDrawColor(FullRenderer::getRenderer(), FullRenderer::colors.r, FullRenderer::colors.g, FullRenderer::colors.b, FullRenderer::colors.a);
	SDL_RenderClear(FullRenderer::getRenderer());
	SDL_RenderPresent(FullRenderer::getRenderer());
	// just keep the window up for now.
	bool winOpen = true;
	while (winOpen) {
		SDL_Event e;
		while (SDL_PollEvent(&e) > 0) {
			SDL_UpdateWindowSurface(FullRenderer::getWindow());
		}
	}
}