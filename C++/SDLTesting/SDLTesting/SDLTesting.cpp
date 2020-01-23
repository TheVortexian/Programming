#define SDL_MAIN_HANDLED
#include "FullRenderer.h"
#include <Windows.h>
FullRenderer* fullRenderer;
#undef main
// WINAPI is needed for a windows application, this isn't just a console application anymore

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance, LPSTR lpCmdLine, int nShowCmd)
{
	// stolen from loki lmao
#ifdef _DEBUG
	AllocConsole();
	AttachConsole(GetCurrentProcessId());
	std::FILE* pCon;
	freopen_s(&pCon, "CON", "w", stdout);
#endif
	char s[] = "im a string";
	//	FullRenderer(char* name, int w, int h, SDL_WindowFlags wF, SDL_RendererFlags rF, int r, int g, int b, int a);
	fullRenderer = new FullRenderer(s, 1000, 650, SDL_WINDOW_RESIZABLE, SDL_RENDERER_ACCELERATED, 100, 50, 175, 255);
	fullRenderer->showWindow(); // display window
	return 0;
}